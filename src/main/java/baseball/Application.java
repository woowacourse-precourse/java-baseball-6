package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Map;


public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        boolean gameFirstStarted = true;
        while (true) {
            if (gameFirstStarted) {
                output.printStartGame();
                gameFirstStarted = false;
            }

            Computer computer = new Computer();
            computer.pickNumbers();

            while (true) {
                int[] guessNumbers = input.readGuessNumbers();
                Map<String, Integer> result = computer.countStrikesAndBalls(guessNumbers);

                if (printResultAndContinue(result)) {
                    break;
                }
            }

            int retryChoice = input.readRetryChoice();
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


}
