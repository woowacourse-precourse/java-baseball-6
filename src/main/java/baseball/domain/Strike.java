package baseball.domain;

public enum Strike {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3);

    private static final String STRIKE_RANGE_EXCEPTION_MESSAGE = "스트라이크의 유효 범위는 0~3 입니다.";
    public static final String EMPTY = "";
    public static final String STRIKE_MESSAGE = "스트라이크";
    private final int count;

    Strike(int strike) {
        this.count = strike;
    }

    public static Strike from(int count) {
        for (Strike strike : values()) {
            if (strike.count == count) {
                return strike;
            }
        }
        throw new IllegalArgumentException(STRIKE_RANGE_EXCEPTION_MESSAGE);
    }

    public boolean isEmpty() {
        return Strike.ZERO.equals(this);
    }

    public boolean isFullCount() {
        return Strike.THREE.equals(this);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return EMPTY;
        }
        return this.count + STRIKE_MESSAGE;
    }
}
