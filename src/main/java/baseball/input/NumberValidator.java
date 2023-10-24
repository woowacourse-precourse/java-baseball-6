package baseball.input;

public class NumberValidator {
    public static boolean isValid(String input) {
        return input.chars().allMatch(Character::isDigit);  // 모든 문자가 숫자인지 확인
    }
}
