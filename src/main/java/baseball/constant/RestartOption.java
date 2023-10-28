package baseball.constant;

public enum RestartOption {

    EXIT("1"),
    RESTART("2");

    private final String option;

    RestartOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
