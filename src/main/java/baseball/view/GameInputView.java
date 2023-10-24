package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameInputView {

    private static final String WHITESPACES_REGEX = "\\s+";
    private static final String BLANK_STRING = "";

    public static String readBallNumbers() {
        String input = Console.readLine();
        return trimmedString(input);
    }

    private static String trimmedString(String input) {
        return input.replaceAll(WHITESPACES_REGEX, BLANK_STRING);
    }

}
