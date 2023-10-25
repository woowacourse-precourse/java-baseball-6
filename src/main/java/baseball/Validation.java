package baseball;

public class Validation {
    // 입력 유효성 검사: 빈 입력값 확인
    public static void checkIsEmpty(String arg, String message) {
        if (arg.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    // 입력 유효성 검사: 숫자가 아닌 입력값(문자열) 확인
    public static void checkIsNumber(String arg, String message) {
        try {
            Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }
}
