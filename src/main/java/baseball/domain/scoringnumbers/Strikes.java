package baseball.domain.scoringnumbers;

public class Strikes extends ScoringNumbers {
    public Strikes(int value) {
        super(value);
    }

    public Strikes(long value) {
        super((int) value);
    }
}
