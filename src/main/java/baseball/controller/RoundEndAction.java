package baseball.controller;

public enum RoundEndAction {
    CONTINUE("1"), // 게임을 계속
    QUIT("2");     // 게임을 종료

    private String value;

    RoundEndAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
