package baseball;

import baseball.constant.GameConstant;

public record GameResult(int ballCnt, int strikeCnt) {

    public boolean isOnlyStrike() {
        return this.ballCnt == 0 && strikeCnt > 0;
    }

    public boolean isOnlyBall() {
        return this.strikeCnt == 0 && ballCnt > 0;
    }

    public boolean isBallStrike() {
        return this.ballCnt > 0 && strikeCnt > 0 &&
                (this.ballCnt != GameConstant.MAXIMUM_STRIKE_COUNT.getConstant() && this.strikeCnt != (GameConstant.MAXIMUM_STRIKE_COUNT.getConstant()));
    }

    public boolean isThreeStrike() {
        return this.strikeCnt == GameConstant.MAXIMUM_STRIKE_COUNT.getConstant();
    }

    public boolean isNothing() {
        return this.ballCnt == 0 && strikeCnt == 0;
    }

    @Override
    public int ballCnt() {
        return ballCnt;
    }

    @Override
    public int strikeCnt() {
        return strikeCnt;
    }
}
