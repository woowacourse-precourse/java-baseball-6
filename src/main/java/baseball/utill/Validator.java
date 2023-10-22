package baseball.utill;

import java.util.List;

public class Validator {

    private static final int INPUT_LENGTH = 3;
    private static final String ERROR_MESSAGE = "[ERROR] 올바르지 않은 입력입니다";
    public static void validation(List<String> input) {
        validationLength(input);
        validationNumeric(input);
        checkDuplicate(input);
    }

    private static void validationLength(List<String> input) {
        if (input.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void validationNumeric(List<String> input) {
        for (String string : input) {
            checkNumeric(string);
        }
    }
    public static void checkNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void checkDuplicate(List<String> input) {
        List<String> list = input
            .stream()
            .distinct()
            .toList();
        if (list.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
    public static void validationEndSign(String endSign){
        Validator.checkNumeric(endSign);
        int integerEndsign = Integer.parseInt(endSign);
        checkEndSignRange(integerEndsign);
    }
    private static void checkEndSignRange(int sign){
        if(sign > 2){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

}
