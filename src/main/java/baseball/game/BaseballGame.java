package baseball.game;

import baseball.view.GameView;

public class BaseballGame {
    public static void start() throws IllegalAccessException {
        GameView.displayGameStartMessage();
        playGame();

    }

    private static void playGame() throws IllegalAccessException {
        int[] randomNumbers = Computer.generateRandomNumbers();
        while (true) {
            GameView.displayUserInputPrompt();
            int[] guessNumbers = User.getGuessNumbers();

            int[] result = Computer.calculateResult(guessNumbers, randomNumbers);
            GameView.displayGuessResult(Computer.formatResult(result));
        }
    }
}
