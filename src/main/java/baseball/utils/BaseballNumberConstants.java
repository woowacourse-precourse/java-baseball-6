package baseball.utils;

public enum BaseballNumberConstants {
    MAX_BASEBALL_NUMBER_SIZE(3),
    START_RANGE(1),
    END_RANGE(9),
    ;

    private final Integer constant;

    BaseballNumberConstants(final Integer constant) {
        this.constant = constant;
    }

    public Integer getConstant() {
        return constant;
    }
}
