package baseball.game;

import baseball.util.ErrorMessage;
import baseball.util.InvalidCustomException;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> secretNumber;
    private boolean gameActive;
    private final GameResult gameResult;

    public BaseballGame() {
        secretNumber = new ArrayList<>();
        gameResult = new GameResult();
    }

    public void initializeGame() {
        secretNumber = GameAnswer.getInstance().generateRandomNumber();
        gameActive = true;
    }

    public void playGame(List<Integer> guess) {
        if (!gameActive) {
            return;
        }

        if (!isValidGuess(guess)) {
            throw new InvalidCustomException(ErrorMessage.INVALID_INPUT);
        }

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (guess.get(i).equals(secretNumber.get(i))) {
                strikes++;
                continue;
            }

            if (secretNumber.contains(guess.get(i))) {
                balls++;
            }
        }

        boolean gameEnded = gameResult.printResult(strikes, balls);
        if (gameEnded) {
            gameActive = false;
        }
    }

    public boolean isGameActive() {
        return gameActive;
    }

    private boolean isValidGuess(List<Integer> guess) {
        if (guess.size() != 3) {
            return false;
        }

        for (int num : guess) {
            if (num < 1 || num > 9) {
                return false;
            }
        }

        return true;
    }
}
