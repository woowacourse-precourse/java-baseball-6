package baseball.domain;

public enum GameOption {
    RESTART("1"),
    END("2");

    private final String option;

    GameOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
