package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final int NUMBER_LENGTH = 3;
    private static final String RESTART_COMMAND = "1";
    private static final boolean RESTART = true;
    private static final boolean END = false;

    public static List<Integer> parseUserNumber(String userNumber) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char number = userNumber.charAt(i);
            userNumbers.add(Character.getNumericValue(number));
        }
        return userNumbers;
    }

    public static boolean parseRestartCommand(String restartCommand) {
        if (restartCommand.equals(RESTART_COMMAND)) {
            return RESTART;
        }
        return END;
    }

}
