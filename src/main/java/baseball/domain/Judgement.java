package baseball.domain;

public enum Judgement {
    STRIKE,
    BALL,
    NOTHING;

    public static Judgement judge(boolean isContain, boolean isInPlace) {
        if (isContain && isInPlace) {
            return STRIKE;
        }
        if (isContain) {
            return BALL;
        }
        return NOTHING;
    }
}
