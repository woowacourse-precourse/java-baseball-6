package baseball.model;

public record Score(int strike, int ball) {

    public boolean isThreeStrike() {
        return strike == 3;
    }
}
