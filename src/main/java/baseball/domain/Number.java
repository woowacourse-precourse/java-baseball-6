package baseball.domain;

import baseball.utils.NumberUtil;

public class Number {
    private static final int MIN = 1;
    private static final int MAX = 9;
    private final int value;

    private Number(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isEquals(final Number number) {
        if (this.value == number.value) {
            return true;
        }
        return false;
    }

    public static Number from(final Object value) {
        if (NumberUtil.validNumberType(value) && NumberUtil.validNumberRange(MIN, MAX, (Integer) value)) {
            return new Number((Integer) value);
        }
        throw new IllegalArgumentException("숫자 타입의 형식이 잘못되었습니다.");
    }
}
