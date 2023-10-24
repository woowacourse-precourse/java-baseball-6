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

        output.printGameStart();

        while (true) {

            playSingleGame();

            if (wantsToStop()) {
                break;
            }
        }
    }

    private void playSingleGame() {

        computer.pickSecretNumbers();

        while (true) {

            List<Integer> guessNumbers = input.getGuessNumbers();
            GameResult gameResult = computer.countStrikesAndBalls(guessNumbers);

            output.printResult(gameResult);
            if (gameResult.isAllStrikes()) {
                break;
            }
        }
    }

    private boolean wantsToStop() {
        int retryChoice = input.getRetryChoice();
        return retryChoice == GameConstants.EXIT_CHOICE;
    }
}
