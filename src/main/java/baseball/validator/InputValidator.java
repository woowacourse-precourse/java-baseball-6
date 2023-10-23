package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {
    private static final int NUMBER_LENGTH = 3;
    private static final String NUMBER_PATTERN = "^[1-9]*$";


    public static void validateCheckRestartGameInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    public static void validatePlayerInput(String input) {
        if (!checkLength(input)) {
            throw new IllegalArgumentException("잘못된 길이의 문자열을 입력했습니다.");
        }

        if (!checkNumberType(input)) {
            throw new IllegalArgumentException("유효하지 않는 문자를 입력했습니다.");
        }

        if (!checkDuplicateNumber(input)) {
            throw new IllegalArgumentException("중복된 숫자를 포함한 문자열을 입력했습니다.");
        }
    }

    private static boolean checkLength(String input) {
        return input.length() == NUMBER_LENGTH;
    }

    private static boolean checkNumberType(String input) {
        return Pattern.matches(NUMBER_PATTERN, input);
    }

    private static boolean checkDuplicateNumber(String input) {
        Set<String> numberSet = new HashSet<>(List.of(input.split("")));
        return numberSet.size() == input.length();
    }
}
