package baseball.view;


import baseball.exception.InvalidInputException;

import static camp.nextstep.edu.missionutils.Console.*;

public class ConsoleInput {

    static final String DIGITS_PATTERN = "^[0-9]+$";
    static final String ONE_OR_TWO_PATTERN  = "^[1-2]+$";

    public static int readDigitNumber(int len) throws InvalidInputException {
        String input = readLine();

        if (validInput(input, len)) {
            throw new InvalidInputException("잘못된 입력입니다.");
        }
        return convertStringToInt(input);
    }

    private static boolean validInput(String input, int length) {
        if (length == 1) {
            return input.length() != length || input.matches(ONE_OR_TWO_PATTERN);
        }
        return input.length() != length || !input.matches(DIGITS_PATTERN) || validDuplicate(input);
    }

    private static boolean validDuplicate(String input) {
        return input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2);
    }

    private static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
