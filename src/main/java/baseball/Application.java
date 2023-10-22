package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public int strike = 0;
    public int ball = 0;

    List<Integer> computer = new ArrayList<>();
    List<Integer> user = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            computer.clear();
            generateRandom();
            System.out.println("computer : " + computer.toString());

            user.clear();
            while (true) {
                getUserInput();
                System.out.println("user : " + user.toString());

                if (judgeStrike()) {
                    System.out.println();
                    System.out.println(strike + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println();
                    break;
                } else {
                    if (strike == 0 & ball == 0) {
                        System.out.println("낫싱");
                    } else {
                        if (strike == 0) {
                            System.out.println(ball + "볼");
                        } else if (ball == 0) {
                            System.out.println(strike + "스트라이크");
                        } else {
                            System.out.println(ball + "볼 " + strike + "스트라이크");
                        }
                    }
                    user.clear();
                }
            }

            if (!reGame()) {
                break;
            }
        }
    }


    public void generateRandom() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void getUserInput() {
        user.clear(); // 기존 입력을 지우고 새로운 입력을 받기 위해 리스트 초기화
        System.out.print("숫자를 입력해주세요: ");
        String userInput = sc.nextLine();
        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (Character.isDigit(c)) {
                int userNum = Character.getNumericValue(c);
                if (userNum >= 1 && userNum <= 9 && !input.contains(userNum)) {
                    input.add(userNum);
                } else {
                    System.out.println("1에서 9 사이의 서로 다른 숫자만 입력하세요.");
                    return; // 입력이 유효하지 않을 때는 바로 반환하도록 수정
                }
            } else {
                System.out.println("올바른 숫자가 아닙니다.");
                return; // 입력이 유효하지 않을 때는 바로 반환하도록 수정
            }
        }

        try {
            validateUserInput(input);
            user.addAll(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }



    public boolean judgeStrike() {
        strike = 0;
        ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == user.get(i)) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }
        return strike == 3;
    }

    public boolean reGame() {
        while (true) {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int n = sc.nextInt();
            if (n == 1) {
                return true;
            } else if (n == 2) {
                return false;
            } else {
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
            }
        }
    }

    public void validateUserInput(List<Integer> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException("세 개의 숫자를 입력해야 합니다.");
        }

        for (int i = 0; i < 3; i++) {
            int userNum = input.get(i);
            if (userNum < 1 || userNum > 9) {
                throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력해야 합니다.");
            }
            for (int j = i + 1; j < 3; j++) {
                if (userNum == input.get(j)) {
                    throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
                }
            }
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }
}



