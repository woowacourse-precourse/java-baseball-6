package baseball.domain.scoringnumbers;

public class ScoringNumbers {
    int value;

    public ScoringNumbers(int value) {
        this.value = value;
    }

    public boolean isZero() {
        return value == 0;
    }

    public int getValue() {
        return value;
    }
}
