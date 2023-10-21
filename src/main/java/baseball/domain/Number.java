package baseball.domain;

import baseball.util.Util;

public class Number{

    private static final int MIN = 1;
    private static final int MAX = 9;
    private final int value;

    private Number(int value) {
        this.value = value;
    };

    public static Number from(Object value) {
        if (Util.validNumberType(value) && Util.validNumberRange(MIN, MAX, (Integer) value)) {
            return new Number((Integer) value);
        }
        throw new IllegalArgumentException("숫자 타입의 형식이 잘못되었습니다.");
    }
}
