package baseball;

import java.util.Map;


public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        boolean gameFirstStarted = true;
        while (true) {
            if (gameFirstStarted) {
                output.printGameStart();
                gameFirstStarted = false;
            }

            Computer computer = new Computer();
            computer.pickNumbers();

            while (true) {
                int[] guessNumbers = input.readGuessNumbers();
                Map<String, Integer> result = computer.countStrikesAndBalls(guessNumbers);

                if (output.printResultAndContinue(result)) {
                    break;
                }
            }

            int retryChoice = input.readRetryChoice();
            if (retryChoice == 2)
                break;

        }

    }



}
