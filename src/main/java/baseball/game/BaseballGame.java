package baseball.game;

import baseball.view.GameView;
import java.util.Arrays;

public class BaseballGame {
    public static void start() throws IllegalAccessException {
        GameView.displayGameStartMessage();
        playGame();

    }

    private static void playGame() throws IllegalAccessException {
        int[] randomNumbers = Computer.generateRandomNumbers();
        System.out.println("randomNumbers = " + Arrays.toString(randomNumbers));
        while (true) {
            GameView.displayUserInputPrompt();
            int[] guessNumbers = User.getGuessNumbers();
            int[] calculateResult = Computer.calculateResult(randomNumbers, guessNumbers);
            String formatResult = Computer.formatResult(calculateResult);
            GameView.displayGuessResult(formatResult);
        }
    }
}
