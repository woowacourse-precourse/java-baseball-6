package baseball.domain;

public enum CommandType {
    RESTART(1), QUIT(2);

    private final int number;

    CommandType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
