package baseball.domain;

public record GameResult(int strike, int ball) {

    public boolean isBallZero() {
        return ball == 0;
    }

    public boolean isStrikeZero() {
        return strike == 0;
    }

}
