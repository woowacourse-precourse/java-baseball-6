package baseball.domain;

import baseball.config.GameConfig;
import baseball.utils.UniqueRandomNumberGenerator;

import java.util.List;

public class BaseballGame {
    private Answer answer;
    private boolean gameEnded;

    public BaseballGame() {
        resetGame();
    }

    public void resetGame() {
        this.answer = new Answer(UniqueRandomNumberGenerator.generateUniqueRandomNumbers(
                GameConfig.START_OF_RANGE.getValue(),
                GameConfig.END_OF_RANGE.getValue(),
                GameConfig.DIGIT_COUNT.getValue()
        ));
        this.gameEnded = false;
    }

    public GuessResult guess(List<Integer> userInput) {
        GuessResult result = answer.checkAgainst(userInput);
        if (result.strikes() == GameConfig.DIGIT_COUNT.getValue()) {
            gameEnded = true;
        }
        return result;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }
}
