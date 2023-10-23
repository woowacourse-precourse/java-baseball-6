package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력해야 합니다.";

    public static String readLine() {
        String input = Console.readLine();
        validateNumber(input);
        return input;
    }

    private static void validateNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
