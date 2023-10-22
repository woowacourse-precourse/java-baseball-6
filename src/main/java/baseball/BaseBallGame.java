package baseball;

import java.util.Map;

public class BaseBallGame {
    private Input input;
    private Output output;
    private Computer computer;

    public BaseBallGame() {
        this.input = new Input();
        this.output = new Output();
        this.computer = new Computer();
    }

    public void play() {

        boolean gameFirstStarted = true;

        while (true) {
            if (gameFirstStarted) {
                output.printGameStart();
                gameFirstStarted = false;
            }

            computer = new Computer();
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
