package baseball.util;

import baseball.domain.Constants;
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static List<Integer> parseUserNumber(String userNumber) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < Constants.NUMBER_LENGTH; i++) {
            char number = userNumber.charAt(i);
            userNumbers.add(Character.getNumericValue(number));
        }
        return userNumbers;
    }

    public static boolean parseRestartCommand(String restartCommand) {
        if (restartCommand.equals(Constants.RESTART_COMMAND)) {
            return Constants.RESTART;
        }
        return Constants.END;
    }

}
