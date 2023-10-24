package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean isCorrectValue(String user) {
        // 올바른 입력 값인지 확인하는 메서드
        try {
            Integer.parseInt(user);
            if (user.length() == 3 && !user.contains("0")) {
                for (int i = 0; i < 3; i++) {
                    if (user.indexOf(user.charAt(i)) != i) {
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean numberBaseballCalc(List<Integer> computer, String user) {
        // 숫자 야구 계산 메서드
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == Character.getNumericValue(user.charAt(i))) {
                strike++;
            } else if (computer.contains(Character.getNumericValue(user.charAt(i)))) {
                ball++;
            }
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        } else if (strike == 0) {
            System.out.println(ball + "볼");
            return false;
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
            return false;
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return false;
        }
    }

    public static void randomNumber(List<Integer> computer) {
        // 랜덤 숫자 생성 메서드
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void main(String[] args) {
        // 숫자 야구 메인 메서드
        List<Integer> computer = new ArrayList<>();
        randomNumber(computer);
//        System.out.println("computer = " + computer); // 컴퓨터 숫자 확인용
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean rightAnswer = false;
        String user = "";
        while (true) {
            if (rightAnswer) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String game = Console.readLine();
                if (game.equals("1")) {
                    computer.clear();
                    randomNumber(computer);
                    rightAnswer = false;
//                    System.out.println("computer = " + computer); // 컴퓨터 숫자 확인용
                } else if (game.equals("2")) {
                    break;
                } else {
                    throw new IllegalArgumentException(); // 잘못된 값이면 예외 발생
                }
            }
            System.out.print("숫자를 입력해주세요 : ");
            user = Console.readLine();
            if (!isCorrectValue(user)) {
                throw new IllegalArgumentException(); // 잘못된 값이면 예외 발생
            }
            rightAnswer = numberBaseballCalc(computer, user);
        }
    }
}
