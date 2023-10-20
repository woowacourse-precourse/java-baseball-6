package baseball.domain.number;

import baseball.domain.number.validation.GameNumbersValidation;
import java.util.List;

public class GameNumber {

    private final List<Integer> gameNumber;

    public GameNumber(List<Integer> gameNumber) {
        GameNumbersValidation.validate(gameNumber);
        this.gameNumber = gameNumber;
    }

    public Integer findDigitIndex(Integer number) {
        return gameNumber.indexOf(number);
    }
}
