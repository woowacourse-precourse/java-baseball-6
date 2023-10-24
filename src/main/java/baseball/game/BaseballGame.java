package baseball.game;

import baseball.view.GameView;

public class BaseballGame {
    private final Computer computer;
    private final User user;

    public BaseballGame() {
        computer = new Computer();
        user = new User();
    }

    public void start() {
        GameView.displayGameStartMessage();
        while (true) {
            play();
            if (!playAgain()) {
                GameView.displayGameEndMessage();
                break;
            }
        }
    }

    private void play() {
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

    private boolean playAgain() {
        GameView.displayGameRestartPrompt();
        int choice = user.getChoiceToPlayAgain();
        return choice == 1;
    }
}
