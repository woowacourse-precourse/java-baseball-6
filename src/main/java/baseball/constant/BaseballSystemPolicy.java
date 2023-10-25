package baseball.constant;

public enum BaseballSystemPolicy {
    MINIMUM_NUMBER(1),
    REPLAY(1),
    EXIT(2),
    LIMIT_LENGTH(3),
    ALL_STRIKE(3),

    MAXIMUM_NUMBER(9);

    private int condition;

    BaseballSystemPolicy(int condition) {
        this.condition = condition;
    }

    public int getCondition() {
        return condition;
    }
}
