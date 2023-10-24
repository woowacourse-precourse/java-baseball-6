package baseball.model.player;

import static baseball.exception.GuessNumberValidator.isGuessNumberValid;

public class GuessNumber {

    private Integer number;

    public GuessNumber(Integer number) {
        validateGuessNumber(number);
        this.number = number;
    }

    private void validateGuessNumber(Integer number) {
        if (!isGuessNumberValid(number)) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getNumber() {
        return number;
    }
}
