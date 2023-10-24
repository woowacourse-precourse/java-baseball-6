package baseball.utill;

import java.util.List;

public class Validator {

    private static final int INPUT_LENGTH = 3;

    public void validation(List<String> input) {
        validationLength(input);
        validationNumeric(input);
        checkDuplicate(input);
    }

    private void validationLength(List<String> input) {
        if (input.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LENGTH.getMessage());
        }
    }

    private void validationNumeric(List<String> input) {
        for (String string : input) {
            checkNumeric(string);
        }
    }

    public void checkNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BALL_COUNT.getMessage());
        }
    }

    private void checkDuplicate(List<String> input) {
        List<String> list = input.stream()
                .distinct()
                .toList();
        if (list.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LIST.getMessage());
        }
    }

    public void validationEndSign(String endSign) {
        checkNumeric(endSign);
        int integerEndsign = Integer.parseInt(endSign);
        checkEndSignRange(integerEndsign);
    }

    private void checkEndSignRange(int sign) {
        if (sign > 2 || sign < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COMMAND.getMessage());
        }
    }

}
