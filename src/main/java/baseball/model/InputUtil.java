package baseball.model;

public class InputUtil {

    // 숫자가 맞는지 검증하는 메서드
    public static void checkIsNumber(String userInput) {
        if (!userInput.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }
}
