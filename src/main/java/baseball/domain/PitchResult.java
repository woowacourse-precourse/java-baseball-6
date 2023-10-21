package baseball.domain;

public enum PitchResult {

    BALL("볼"), STRIKE("스트라이크");

    private final String description;

    PitchResult(String description) {
        this.description = description;
    }
}
