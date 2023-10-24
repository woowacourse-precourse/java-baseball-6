package baseball.view.input;

import camp.nextstep.edu.missionutils.Console;

public class MainInputView {

    private static final String WHITESPACES_REGEX = "\\s+";
    private static final String BLANK_STRING = "";

    public static boolean readShouldStartNewGame() {
        String input = Console.readLine();
        String trimmededInput = trimmedString(input);

        return MainCommand.shouldStartNewGame(trimmededInput);
    }

    private static String trimmedString(String input) {
        return input.replaceAll(WHITESPACES_REGEX, BLANK_STRING);
    }

}
