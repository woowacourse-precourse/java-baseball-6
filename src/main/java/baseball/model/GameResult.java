package baseball.model;

public record GameResult(int ball, int strike) {

    public boolean isThreeStrikes() {
        return strike == 3;
    }
}