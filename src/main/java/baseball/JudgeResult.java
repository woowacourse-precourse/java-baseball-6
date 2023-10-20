package baseball;

class JudgeResult {

    private final int ball;
    private final int strike;
    private final JudgeStatus status;

    JudgeResult(int ball, int strike, JudgeStatus status) {
        this.ball = ball;
        this.strike = strike;
        this.status = status;
    }

    int getBall() {
        return ball;
    }

    int getStrike() {
        return strike;
    }

    JudgeStatus getStatus() {
        return status;
    }
}
