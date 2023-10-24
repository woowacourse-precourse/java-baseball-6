package baseball.constant;

public enum StatusMessage {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");
    public String statusName;

    StatusMessage(String statusName) {
        this.statusName = statusName;
    }
}
