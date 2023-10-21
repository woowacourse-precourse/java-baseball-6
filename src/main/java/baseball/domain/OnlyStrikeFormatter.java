package baseball.domain;

public class OnlyStrikeFormatter implements StringFormatter {
    @Override
    public String format(int ball, int strike) {
        return String.format("%d%s", strike, Hint.STRIKE.value());
    }
}
