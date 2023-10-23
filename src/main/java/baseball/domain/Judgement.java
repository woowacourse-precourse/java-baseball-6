package baseball.domain;

public enum Judgement {
    STRIKE,
    BALL,
    NOTHING;

    public static Judgement judge(boolean isContains, boolean isInPlace) {
        if (isContains && isInPlace) {
            return STRIKE;
        }
        if (isContains) {
            return BALL;
        }
        return NOTHING;
    }
}
