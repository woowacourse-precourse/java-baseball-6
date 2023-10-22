package model;

public enum GameHint {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String message;

    GameHint(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
