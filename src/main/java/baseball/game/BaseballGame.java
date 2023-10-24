package baseball.game;

import baseball.view.GameView;

public class BaseballGame {
    private final Computer computer;
    private final User user;
    private static final int PLAY_AGAIN_CHOICE = 1;

    public BaseballGame() {
        computer = new Computer();
        user = new User();
    }

    public void start() {
        GameView.displayGameStartMessage();

        while (true) {
            playGame();

            if (!wantsToPlayAgain()) {
                GameView.displayGameEndMessage();
                break;
            }
        }
    }

    private void playGame() {
        int[] randomNumbers = computer.generateRandomNumbers();

        while (true) {
            GameView.displayUserInputPrompt();
            int[] guessNumbers = user.getGuessNumbers();

            int[] result = computer.calculateResult(guessNumbers, randomNumbers);
            GameView.displayGuessResult(computer.formatResult(result));

            if (computer.isGameOver(result)) {
                GameView.displayCorrectGuessMessage();
                break;
            }
        }
    }

    private boolean wantsToPlayAgain() {
        GameView.displayGameRestartPrompt();
        int choice = user.getChoiceToPlayAgain();
        return choice == PLAY_AGAIN_CHOICE;
    }
}
