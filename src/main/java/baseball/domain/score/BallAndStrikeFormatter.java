package baseball.domain.score;

public class BallAndStrikeFormatter implements StringFormatter {
    @Override
    public String format(int ball, int strike) {
        return String.format("%d%s %d%s", ball, Hint.BALL.value(), strike, Hint.STRIKE.value());
    }
}
