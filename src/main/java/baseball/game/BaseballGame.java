package baseball.game;

import baseball.view.GameView;

public class BaseballGame {
    public static void start() {
        GameView.displayGameStartMessage();
        while (true) {
            play();
            if (!playAgain()) {
                GameView.displayGameEndMessage();
                break;
            }
        }
    }

    private static void play() {
        int[] randomNumbers = Computer.generateRandomNumbers();
        while (true) {
            GameView.displayUserInputPrompt();
            int[] guessNumbers = User.getGuessNumbers();

            int[] result = Computer.calculateResult(guessNumbers, randomNumbers);
            GameView.displayGuessResult(Computer.formatResult(result));

            if (Computer.isGameOver(result)) {
                GameView.displayCorrectGuessMessage();
                break;
            }
        }
    }

    private static boolean playAgain() {
        GameView.displayGameRestartPrompt();
        int choice = User.getChoiceToPlayAgain();
        return choice == 1;
    }
}
