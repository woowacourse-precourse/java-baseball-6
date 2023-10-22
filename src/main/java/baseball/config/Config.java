package baseball.config;

public class Config {

    private static final int MAX_NUMBERS = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    static {
        if ( MAX_NUMBERS == 0 || (START_INCLUSIVE + MAX_NUMBERS - 1) > END_INCLUSIVE || MAX_NUMBERS > END_INCLUSIVE) throw new IllegalArgumentException("숫자는 올바른 범위여야 합니다.");
    }

    public static int getMaxNumbers() {
        return MAX_NUMBERS;
    }

    public static int getStartInclusive() {
        return START_INCLUSIVE;
    }

    public static int getEndInclusive() {
        return END_INCLUSIVE;
    }

}
