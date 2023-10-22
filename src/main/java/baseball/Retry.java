package baseball;

public enum Retry {
    RETRY(1),
    END(2);

    private final int checkNumber;

    Retry(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public int getCheckNumber() {
        return checkNumber;
    }
}
