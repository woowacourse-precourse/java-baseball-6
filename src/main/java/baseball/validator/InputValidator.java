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
}
