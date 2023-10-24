package baseball.global.enums;

public enum GameResult {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    PERFECT("3스트라이크");

    public final String name;

    GameResult(String name) {
        this.name = name;
    }
}
