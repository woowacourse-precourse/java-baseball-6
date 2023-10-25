package baseball.validation;

import baseball.constant.message.GameMessage;
import baseball.constant.value.GameValue;

import java.util.HashSet;
import java.util.Set;

public class InputNumberValidation {

    public static String inputThreeNumberValidate(String input) {
        if (isLengthThree(input) && isNumberFormat(input) && isDuplicate(input)) {
            return input;
        }
        throw new IllegalArgumentException(GameMessage.EXCEPTION_INPUT);
    }

    public static String inputSelectValidation(String input) {
        if (isLengthOne(input) && isFlagNumberFormat(input)) {
            return input;
        }
        throw new IllegalArgumentException(GameMessage.EXCEPTION_INPUT);
    }

    private static boolean isLengthThree(String input) {
        return input.length() == GameValue.INPUT_LENGTH_THREE;
    }

    private static boolean isNumberFormat(String input) {
        return input.matches("[1-9]+");
    }

    private static boolean isDuplicate(String input) {
        Set<Character> set = new HashSet<>();

        for (char ch : input.toCharArray()) {
            set.add(ch);
        }

        return set.size() == GameValue.INPUT_LENGTH_THREE;
    }

    private static boolean isLengthOne(String input) {
        return input.length() == GameValue.LENGTH_ONE;
    }

    private static boolean isFlagNumberFormat(String input) {
        return input.equals(GameValue.RETRY) || input.equals(GameValue.EXIT);
    }
}
