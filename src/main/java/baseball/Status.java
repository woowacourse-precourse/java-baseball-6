package baseball;

public enum Status {
    START(0),
    RETRY(1),
    EXIT(2);

    private final int statusNumber;

    Status(int statusNumber) {
        this.statusNumber = statusNumber;
    }

    public int getStatusNumber() {
        return statusNumber;
    }
}
