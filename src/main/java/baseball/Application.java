package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.PlayGame();
    }
}

class BaseballGame {
    public void PlayGame() {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            int computerNumber = generateComputerNumber();

            while (true) {
                System.out.print("세자리 숫자를 입력하세요 : ");
                String userInput = Console.readLine();

                if (isValidInput(userInput)) {
                    int usernumber = Integer.parseInt(userInput);
                    String result = calculateResult(usernumber, computerNumber);

                    System.out.println(result);

                    if (result.equals("3스트라이크")) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("올바른 입력이 아닙니다.");
                }
            }
            System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if ("2".equals(choice)) {
                System.out.println("게임 종료");
                return;
            }

        }
    }

    private int generateComputerNumber() {
        int num1, num2, num3;

        do {
            num1 = Randoms.pickNumberInRange(1, 9);
            num2 = Randoms.pickNumberInRange(1, 9);
            num3 = Randoms.pickNumberInRange(1, 9);
        } while (num1 == num2 || num1 == num3 || num2 == num3);

        return num1 * 100 + num2 * 10 + num3;
    }

    private static boolean isValidInput(String userInput) {
        return userInput.matches("^[1-9]{3}$");
    }

    private String calculateResult(int userNumber, int computerNumber) {
        String usernum = String.valueOf(userNumber);
        String comnum = String.valueOf(computerNumber);

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (usernum.charAt(i) == comnum.charAt(i)) {
                strike++;
            } else if (comnum.contains(String.valueOf(usernum.charAt(i)))) {
                ball++;
            }
        }
        if (strike == 3) {
            return "3스트라이크";
        } else if (strike > 0 && ball > 0) {
            return ball + "볼" + " " + strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else if (strike > 0) {
            return strike + "스트라이크";
        } else {
            return "낫싱";
        }
    }
}