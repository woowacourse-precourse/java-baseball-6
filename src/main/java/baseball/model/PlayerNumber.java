package baseball.model;

import static baseball.validator.PlayerNumberValidator.*;

public class PlayerNumber {
    private String playerNumber;

    public PlayerNumber(String number) {

        validateNumberLen(number);
        validateNonInteger(number);
        validateDuplicateNumber(number);
        validateNumberRange(number);
        validateMinusNumber(number);

        this.playerNumber = number;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }
}
