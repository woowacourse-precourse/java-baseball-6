package baseball.dto;

public record GameResult(int strike, int ball) {

    public boolean isClear() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isStrikeOnly() {
        return !isNothing() && ball == 0;
    }

    public boolean isBallOnly() {
        return !isNothing() && strike == 0;
    }
}
