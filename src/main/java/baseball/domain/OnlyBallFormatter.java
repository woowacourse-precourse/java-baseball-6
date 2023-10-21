package baseball.domain;

public class OnlyBallFormatter implements StringFormatter {
    @Override
    public String format(int ball, int strike) {
        return String.format("%d%s", ball, Hint.BALL.value());
    }
}
