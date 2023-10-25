package baseball;

import java.util.regex.Pattern;

import static baseball.GameService.toInt;
import static baseball.messageConstant.ErrorMessageConstant.*;

public class GameException {
    private static final Pattern NUMBER_DIGIT_MATCH = Pattern.compile("^[1-9]*$");

    public void playerNumberLengthException(String inputPlayerNumber) {
        if (inputPlayerNumber.length() != 3)
            throw new IllegalArgumentException(PLAYER_INPUT_NUMBER_LENGTH_ERROR_MESSAGE);
    }

    public void playerNumberTypeException(String inputPlayerNumber) {
        if (!NUMBER_DIGIT_MATCH.matcher(inputPlayerNumber).matches())
            throw new IllegalArgumentException(PLAYER_INPUT_NUMBER_RANGE_ERROR_MESSAGE);
    }

    public void playerNumberDuplicateException(int[] playerNumbers, char storeNumber) {
        for (int playerNumber : playerNumbers) {
            if (playerNumber == toInt(storeNumber))
                throw new IllegalArgumentException(PLAYER_INPUT_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void playerRetryNumberMissMatchException() {
        throw new IllegalArgumentException(PLAYER_INPUT_RETRY_NUMBER_ERROR_MESSAGE);
    }
}