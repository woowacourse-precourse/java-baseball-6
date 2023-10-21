package baseball.validator;

public class InputValidator {

    public static boolean isThreeChar(String input) {
        if (input.length() == 3) {
            return true;
        }
        throw new IllegalArgumentException("입력값의 길이가 3이 아닙니다");
    }

    public static boolean isNumber(String input) {
        if (input.chars().anyMatch(c -> !Character.isDigit(c))) {
            throw new IllegalArgumentException("입력값에 문자가 포함되어 있습니다.");
        }
        return true;
    }

    public static boolean isBetweenOneAndNine(String input) {
        if (input.chars().anyMatch(c -> c < '1' || c > '9')) {
            throw new IllegalArgumentException("입력값이 1~9 사이의 숫자가 아닙니다.");
        }
        return true;
    }

    public static boolean isNotDuplicate(String input) {
        if (input.chars().distinct().count() != input.length()) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }
        return true;
    }

    public static boolean isLengthOne(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("1 또는 2의 한 글자만 입력 가능합니다.");
        }
        return true;
    }

    public static boolean isEqualToOneOrTwo(String input) {
        if (input.charAt(0) != '1' && input.charAt(0) != '2') {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
        return true;
    }
}
