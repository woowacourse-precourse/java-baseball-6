package baseball;

public class ErrorDetector {

    public static void throwIfNumbersInputInvalid(String numbers) {
        throwIfContainsNonNumber(numbers);
        if (numbers.length() != 3) {
            // 에러 메시지 출력
             throw new IllegalArgumentException();
        }
    }

    public static void throwIfOptionInputInvalid(String option) {
        throwIfContainsNonNumber(option);
        int op = Integer.parseInt(option);
        if (op != 1 && op != 2) {
            // 에러 메시지 출력
            throw new IllegalArgumentException();
        }
    }

    private static void throwIfContainsNonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            // 에러 메시지 출력
            throw new IllegalArgumentException();
        }
    }
}
