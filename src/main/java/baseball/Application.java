package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Map;


public class Application {
    public static void main(String[] args) {
        boolean gameFirstStarted = true;
        while (true) {
            if (gameFirstStarted) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                gameFirstStarted = false;
            }

            Computer computer = new Computer();
            computer.pickNumbers();

            while (true) {
                Input input = new Input();
                int[] guessNumbers = input.readGuessNumbers();
                Map<String, Integer> result = computer.countStrikesAndBalls(guessNumbers);

                if (printResultAndContinue(result)) {
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int retryChoice = stringToIntThrowException(Console.readLine());
            if (retryChoice == 2)
                break;

        }

    }


    public static boolean printResultAndContinue(Map<String, Integer> result) {

        int strikes = result.get("strikes");
        int balls = result.get("balls");

        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }

        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }

        if (balls == 0 && strikes == 0){
            System.out.print("낫싱");
        }

        System.out.println();

        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private static int stringToIntThrowException(String input) {
        input = input.replaceAll("\\s", "");

        if (!input.matches("[12]"))
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");

        return Integer.parseInt(input);
    }
}
