package baseball.game;

import baseball.view.GameView;
import java.util.Arrays;

public class BaseballGame {
    public static void start() throws IllegalAccessException {
        GameView.displayGameStartMessage();
        while (true) {
            playGame();
            if (!playAgain()) {
                GameView.displayGameEndMessage();
                break;
            }
        }
    }

    private static void playGame() throws IllegalAccessException {
        int[] randomNumbers = Computer.generateRandomNumbers();
        System.out.println("randomNumbers = " + Arrays.toString(randomNumbers));
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
