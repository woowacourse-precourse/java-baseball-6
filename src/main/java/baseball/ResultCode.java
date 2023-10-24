package baseball;

public enum ResultCode {
    BALL(0, "볼"), STRIKE(1, "스트라이크"), MISS(2, "낫싱");
    public int value;
    public String title;

    ResultCode(int value, String title) {
        this.value = value;
        this.title = title;
    }
}