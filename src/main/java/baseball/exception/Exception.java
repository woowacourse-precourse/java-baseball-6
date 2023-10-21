package baseball.exception;

public class Exception {

    public static void checkException(String input) {
        if (input.length() > 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }
    public static void isNumeric(String input) {
        if(input.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
}
