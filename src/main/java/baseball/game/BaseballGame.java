package baseball.game;

import baseball.view.GameView;

public class BaseballGame {
    public static void start() {
        GameView.displayGameStartMessage();
        playGame();

    }

    private static void playGame() {
        int[] randomNumbers = Computer.generateRandomNumbers();
        while (true) {
            GameView.displayUserInputPrompt();
            int[] guessNumbers = User.getGuessNumbers();
        }
    }
}
