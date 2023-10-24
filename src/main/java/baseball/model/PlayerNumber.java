package baseball.model;

import java.util.List;

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

    public List<Integer> getPlayerNumber() {
        List<Integer> playNum= PlayerInputNumber.inputNumberList(playerNumber);

        return playNum;
    }
}
