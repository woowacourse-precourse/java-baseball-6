package baseball.entity;

enum BallStatus {

    BALL, STRIKE, NOTHING;

    public boolean isBall() {
        return this.equals(BALL);
    }

    public boolean isStrike() {
        return this.equals(STRIKE);
    }

    public boolean isHint() {
        return isBall() || isStrike();
    }

    public boolean isNothing() {
        return this.equals(NOTHING);
    }
}
