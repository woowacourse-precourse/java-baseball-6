package baseball.Game;

public enum Choice {
    RESTART("1"),
    EXIT("2");

    private final String choice;

    Choice(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }
}
