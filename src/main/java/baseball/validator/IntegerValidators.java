package baseball.validator;

public final class IntegerValidators {

    public static void validateRange(int value, int minValue, int maxValue) {
        boolean isUnderValue = value < minValue;
        boolean isOverValue = value > maxValue;
        if (isUnderValue || isOverValue) {
            throw new IllegalArgumentException("값이 범위에 대해 유효하지 않습니다");
        }
    }

}
