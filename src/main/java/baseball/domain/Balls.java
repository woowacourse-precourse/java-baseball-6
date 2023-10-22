package baseball.domain;

public class Balls extends ScoringNumbers {

    public Balls(int value) {
        super(value);
    }

    public Balls(long value) {
        super((int) value);
    }
}
