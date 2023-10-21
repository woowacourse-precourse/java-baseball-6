package baseball.domain;

public class BothZeroFormatter implements StringFormatter {
    @Override
    public String format(int ball, int strike) {
        return Hint.NOTHING.value();
    }
}
