package baseball.game.menu;

import static baseball.game.message.ErrorMessage.INVALID_MENU;

public enum GameMenu {
    CONTINUE,
    FINISH;

    public static GameMenu ordinalOf(String ordinalText) {
        int ordinal = Integer.parseInt(ordinalText) - 1;
        validate(ordinal);
        return GameMenu.values()[ordinal];
    }

    private static void validate(int ordinal) {
        if (ordinal >= GameMenu.values().length) {
            throw new IllegalArgumentException(INVALID_MENU.getMessage());
        }
    }
}
