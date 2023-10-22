package baseball;

import static baseball.Message.*;

public class ExceptionHandler {
    private static String readLine;

    public ExceptionHandler(String readLine) {
        this.readLine = readLine;
    }

    public void handleStart(String readLine) {
        String outOfRangeMessage = INPUT_THREE_NUMBER.getMessage();

        if (readLine == null) {
            throw new IllegalArgumentException(outOfRangeMessage);
        }

        if (readLine.length() != 3 || readLine.matches(".*\\D.*")) {
            throw new IllegalArgumentException(outOfRangeMessage);
        }

    }


    public void handleExecute(String readLine) {
        String outOfRangeMessage = INPUT_THREE_NUMBER.getMessage();
        if (readLine == null) {
            throw new IllegalArgumentException(outOfRangeMessage);
        }

        try {
            int input = Integer.parseInt(readLine);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(outOfRangeMessage);
        }
    }

    public static void handleExit(String readLine) {
        String invalidMessage = INPUT_RIGHT_NUMBER.getMessage();
        if (readLine == null) {
            throw new IllegalArgumentException(invalidMessage);
        }

        try {
            int input = Integer.parseInt(readLine);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(invalidMessage);
        }
    }

}
