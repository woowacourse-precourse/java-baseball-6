package baseball.domain.enums;

public enum Constants {
    NUM_SIZE(3),
    NUM_START(1),
    NUM_END(9),

    RETRY(1),
    END(2);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
