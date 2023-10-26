package baseball;

import static baseball.Message.*;

public class ExceptionHandler {
    private static String readLine;

    public ExceptionHandler(String readLine) {
        this.readLine = readLine;
    }


    public static void handleExecute(String readLine) {
        String outOfRangeMessage = INPUT_THREE_NUMBER.getMessage();
        handleNullOrInvalid(readLine, outOfRangeMessage);
    }

    private static void handleNullOrInvalid(String readLine, String outOfRangeMessage) {
        if (readLine == null) {
            throw new IllegalArgumentException(outOfRangeMessage);
        }

        if (readLine.length() != 3 || readLine.matches(".*\\D.*")) {
            throw new IllegalArgumentException(outOfRangeMessage);
        }
    }

    public static void handleExit(String readLine) {
        String invalidMessage = INPUT_RIGHT_NUMBER.getMessage();
        if (readLine == null) {
            throw new IllegalArgumentException(invalidMessage);
        }
        int input = Integer.parseInt(readLine);

        if (input != 1 && input != 2) {
            throw new IllegalArgumentException(invalidMessage);
        }
    }
}
