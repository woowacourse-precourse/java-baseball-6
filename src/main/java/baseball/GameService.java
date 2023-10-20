package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.GameResult;
import baseball.domain.InputValidator;

import java.util.List;

import static baseball.InputConstant.*;

public class GameService {

    private final InputValidator inputValidator;
    private BaseballNumbers baseballNumbers;
    private final GameResult gameResult;

    public GameService(InputValidator inputValidator, GameResult gameResult) {
        this.inputValidator = inputValidator;
        this.gameResult = gameResult;
    }

    public void generateNumber() {
        this.baseballNumbers = new BaseballNumbers();
    }

    public String getGameResult(String input) {
        List<Integer> userInputNumbers = inputValidator.validateInputNumbers(input);

        gameResult.strikeOrBall(baseballNumbers.getNumbers(), userInputNumbers);

        return gameResult.toString();
    }

    public boolean isWin() {
        return gameResult.isWin();
    }

    public boolean endOrRestartGame(String input) {
        if (inputValidator.validEndNumber(input) == END_GAME.getNum()) return true;

        return false;
    }
}
