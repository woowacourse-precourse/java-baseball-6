package baseball;

import java.util.regex.Pattern;

import static baseball.GameService.toInt;
import static baseball.messageConstant.ErrorMessageConstant.*;

public class GameException {
    private static final Pattern NUMBER_DIGIT_MATCH = Pattern.compile("^[1-9]*$");

    public void playerNumberLengthException(String inputPlayerNumber) throws IllegalArgumentException {
        if (inputPlayerNumber.length() != 3)
            throw new IllegalArgumentException(PLAYER_INPUT_NUMBER_LENGTH_ERROR_MESSAGE);
    }

    public void playerNumberRangeException(String inputPlayerNumber) throws IllegalArgumentException {
        if (!NUMBER_DIGIT_MATCH.matcher(inputPlayerNumber).matches())
            throw new IllegalArgumentException(PLAYER_INPUT_NUMBER_RANGE_ERROR_MESSAGE);
    }

    public void playerNumberDuplicateException(int[] playerNumbers, char storeNumber) throws IllegalArgumentException {
        for (int playerNumber : playerNumbers) {
            if (playerNumber == toInt(storeNumber))
                throw new IllegalArgumentException(PLAYER_INPUT_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
