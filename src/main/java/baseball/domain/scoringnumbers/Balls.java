package baseball.domain.scoringnumbers;

public class Balls extends ScoringNumbers {
    public Balls(int value) {
        super(value);
    }

    public Balls(long value, Strikes strikes) {
        super((int) value - strikes.get());
    }
}
