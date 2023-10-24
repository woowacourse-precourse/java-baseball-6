package baseball.domain.scoringnumbers;

class ScoringNumbers {
    private final int value;

    ScoringNumbers(int value) {
        this.value = value;
    }

    public boolean isZero() {
        return value == 0;
    }

    public int get() {
        return value;
    }
}
