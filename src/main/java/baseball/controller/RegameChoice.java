package baseball.controller;

public enum RegameChoice {
    RESTART_GAME(1),
    EXIT_GAME(2),
    OTHER_CHOICE(3);

    private final int value;

    RegameChoice(int value) {
        this.value = value;
    }

    public static RegameChoice fromValue(int value) {
        for (RegameChoice choice : RegameChoice.values()) {
            if (choice.value == value) {
                return choice;
            }
        }
        return OTHER_CHOICE;
    }
}

