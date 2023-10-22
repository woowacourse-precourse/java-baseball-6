package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        boolean isGameDone = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
        String computerNumber = makeNumbers();

        while (!isGameDone) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = checkUserInput();
            isGameDone = makeHints(computerNumber, userInput);
            if (isGameDone) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String reply = Console.readLine();
                if (reply.equals("1")) {
                    System.out.println("숫자 야구 게임을 시작합니다.");
                    computerNumber = makeNumbers();
                    isGameDone = false;
                }
            }
        }
    }

    public static String makeNumbers() {
        String numbers = "";
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int i = 0; i < 3; i++) {
            numbers += computer.get(i).toString();
        }

        return numbers;
    }

    public static boolean makeHints(String answer, String userNum) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == userNum.charAt(i)) {
                strike++;
            } else if (answer.indexOf(userNum.charAt(i)) != -1) {
                ball++;
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball > 0 && strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else if (ball == 0 && strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    public static String checkUserInput() {
        String userInput = Console.readLine();
        int t1;
        // 숫자 입력했는지 체크
        try {
            t1 = Integer.parseInt(userInput);
            if (0 > t1 || t1 > 999) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}
