package baseball.util;

public class RetryInputConvertor {

    public static int convertRetryInput(String retryInput) {
        validateInputSize(retryInput);
        int number = Integer.parseInt(retryInput);
        validateNumericInputs(number);
        return number;
    }

    private static void validateInputSize(String retryInput) {
        if (retryInput.length() > 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumericInputs(int number) {
        if (number == -1 || number >= 10) {
            throw new IllegalArgumentException();
        }
    }
}
