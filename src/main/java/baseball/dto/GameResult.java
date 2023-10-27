package baseball.dto;

public record GameResult(int strike, int ball) {

    private static final int WIN_COUNT = 3;

    public boolean isZeroStrike() {
        return strike == 0;
    }

    public boolean isZeroBall() {
        return ball == 0;
    }

    public boolean isNothing() {
        return isZeroStrike() && isZeroBall();
    }

    public boolean isWin() {
        return strike == WIN_COUNT;
    }
}
