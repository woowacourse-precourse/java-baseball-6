package baseball.utils;

public enum Score {
    BALL("ball", "볼"),
    STRIKE("strike", "스트라이크"),
    NOTHING("nothing", "낫싱");

    private final String result;
    private final String num;

    Score(String result, String num) {
        this.result = result;
        this.num = num;
    }

    public String getResult() {
        return result;
    }

    public String getNum() {
        return num;
    }
}
