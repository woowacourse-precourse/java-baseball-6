package baseball;

public enum InputRange {

    START_INDEX(0),
    START_RANDOM_RANGE(1),
    END_RANDOM_RANGE(2),
    CORRECT_INPUT_RANGE(3);

    private final int value;

    InputRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
