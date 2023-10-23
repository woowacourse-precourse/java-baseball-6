package baseball.util;

public enum MagicNumber {

    RESTART(1),
    QUIT(2),
    MAX_SIZE(3),
    MIN_SIZE(0),
    MIN_NUMBER(1),
    MAX_NUMBER(9);

    private final int number;

    MagicNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
