package baseball;

import java.util.List;

public class BaseBallGame {
    private final Input input;
    private final Output output;
    private final Computer computer;

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

            computer.pickSecretNumbers();

            while (true) {
                List<Integer> guessNumbers = input.getGuessNumbers();
                GameResult gameResult = computer.countStrikesAndBalls(guessNumbers);

                if (output.printResultAndContinue(gameResult)) {
                    break;
                }
            }

            int retryChoice = input.getRetryChoice();
            if (retryChoice == GameConstants.EXIT_CHOICE) {
                break;
            }
        }
    }

}
