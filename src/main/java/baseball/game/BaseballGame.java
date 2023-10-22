package baseball.game;

import baseball.output.GameOutput;

public class BaseballGame {
    public static void start() {
        GameOutput.displayGameStartMessage();
        playGame();

    }

    private static void playGame() {
        int[] randomNumbers = Computer.generateRandomNumbers();
        while (true) {
            GameOutput.displayUserInputPrompt();
            int[] guessNumbers = User.getGuessNumbers();
        }
    }
}
