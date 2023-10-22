package baseball.domain;

public enum Regame {
    RESTART_GAME(1),
    EXIT_GAME(2),
    OTHER_CHOICE(3);

    private final int value;

    Regame(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}

