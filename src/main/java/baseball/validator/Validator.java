package baseball.validator;

public class Validator {
    public static int parseValidatedInt(String str) {
        int result = 0;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throwIllegalArgumentException("숫자로 입력받아야 합니다.", e);
        }
        return result;
    }

    public static void validateCiphers(int value, int ciphers) {
        // 세 자리면 100(10^2)으로 나누고, 한 자리면 1(10^0)으로 나눈다.
        int divideBy = (int) Math.pow(10, (ciphers - 1));
        int divisionResult = value / divideBy;
        if (divisionResult <= 0 || divisionResult >= 10) {
            throwIllegalArgumentException("자릿수가 맞지 않습니다.");
        }
    }

    public static void validateInRange(int value, int from, int to) {
        if (value < from || value > to) {
            String format = String.format("%d에서 %d 숫자만 입력해주셔야 합니다.", from, to);
            throwIllegalArgumentException(format);
        }
    }

    private static void throwIllegalArgumentException(String message, Exception e) {
        throw new IllegalArgumentException(message, e);
    }

    private static void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }
}