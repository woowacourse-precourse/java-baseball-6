package baseball.domain.number;

import baseball.domain.number.validation.DigitRangeValidator;
import baseball.domain.number.validation.DuplicateDigitValidator;
import baseball.domain.number.validation.NumberLengthValidator;
import java.util.List;

public class GameNumber {

    private final List<Integer> gameNumber;

    public GameNumber(List<Integer> gameNumber) {
        validate(gameNumber);
        this.gameNumber = gameNumber;
    }

    public Integer findDigitIndex(Integer number) {
        return gameNumber.indexOf(number);
    }

    private void validate(List<Integer> gameNumber) {
        DuplicateDigitValidator.validate(gameNumber);
        DigitRangeValidator.validate(gameNumber);
        NumberLengthValidator.validate(gameNumber);
    }
}
