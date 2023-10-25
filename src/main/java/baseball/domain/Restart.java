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

    public static Restart validateValue(int value) {
        for (Restart choice : Restart.values()) {
            if (choice.getValue() == value) {
                return choice;
            }
        }
        return Restart.OTHER_CHOICE;
    }
}

