package baseball.domain;

public enum Restart {
    RESTART_GAME(1),
    EXIT_GAME(2),
    OTHER_CHOICE(3);

    private final int value;

    Restart(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}

