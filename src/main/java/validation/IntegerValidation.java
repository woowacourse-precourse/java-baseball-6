package validation;

public class IntegerValidation {

    private IntegerValidation() {
    }

    // 정수의 각 자리 숫자 별로 Range validate
    public static void validateRangeEachNumber(int num, final int begin, final int end) {
        while (num > 0) {
            validateRange(num % 10, begin, end);
            num /= 10;
        }
    }

    // 정수의 범위를 validate
    public static void validateRange(final int num, final int begin, final int end) {
        if (num < begin || num > end) {
            throw new IllegalArgumentException();
        }
    }
}
