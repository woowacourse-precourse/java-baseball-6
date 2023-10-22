package utils;

import static utils.GameErrorMessage.INVALID_CONVERT_MESSAGE;

import java.util.List;
import model.referee.GameScoreboard;

public class BaseballMessageConvertor {

    public static String generateScoreMessage(GameScoreboard gameScoreboard) {
        StringBuilder builder = new StringBuilder();
        int strike = gameScoreboard.getStrike();
        int ball = gameScoreboard.getBall();

        return builder.toString();
    }

    public static List<Integer> convertInputToBaseballNumber(String input) {
        if (BaseballNumberUtils.isValidBaseballNumber(input)) {
            return BaseballNumberUtils.createBaseballNumber(input);
        }
        throw new IllegalArgumentException(INVALID_CONVERT_MESSAGE);
    }
}
