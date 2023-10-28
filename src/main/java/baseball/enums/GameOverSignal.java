package baseball.enums;

public enum GameOverSignal {
    START("1"),
    FINISH("2");

    private final String value;

    GameOverSignal(String value) {
        this.value = value;
    }

    public static boolean isNotFinished(String input) {
        return !FINISH.value.equals(input);
    }
}
