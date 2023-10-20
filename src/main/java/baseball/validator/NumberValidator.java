package baseball.validator;

public class NumberValidator {

    public static final int LENGTH = 3;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private NumberValidator() {
        throw new IllegalArgumentException("NumberValidator(): 인스턴스 생성 불가능");
    }

    public static void validateNaturalNumber(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("숫자는 " + MIN_VALUE + "에서 " + MAX_VALUE + "까지여야 합니다.");
        }
    }

    public static boolean needsMoreNumbers(int size) {
        return size < LENGTH;
    }

}
