package baseball.baseballV2.model;

public enum RestartChoice {
    ONE("Restart"),
    TWO("Terminate");

    private final String description;

    RestartChoice(String description) {
        this.description = description;
    }
}
