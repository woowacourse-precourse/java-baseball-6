package baseball.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputViewUtils {

    private static final String WHITESPACES_REGEX = "\\s+";
    private static final String BLANK_STRING = "";

    private InputViewUtils() {
    }

    static String readLine() {
        return Console.readLine();
    }

    static String trimmedString(String input) {
        return input.replaceAll(WHITESPACES_REGEX, BLANK_STRING);
    }

}
