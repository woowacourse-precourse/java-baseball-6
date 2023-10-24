package baseball.input;

public class EndValidator {
    public static void isValid(String input) {
        if (Integer.parseInt(input) != 1 && Integer.parseInt(input) != 2) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
