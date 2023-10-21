package baseball;

public class ErrorDetector {

    // 입력 받은 숫자 값 유효성 확인
    public static void throwIfNumberIsWrong(String number) {
        throwIfInputIsString(number);
        if (number.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    // 입력 받은 옵션 값 유효성 확인
    public static void throwIfOptionIsWrong(String option) {
        throwIfInputIsString(option);
        if (!option.equals("1") && !option.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    // 입력 받은 값이 숫자인지 확인
    public static void throwIfInputIsString(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
