package baseball.model;

public class BaseballGameCounts {
    private int strikes;
    private int balls;
    private String message;

    protected BaseballGameCounts() {}

    public static BaseballGameCounts createBaseballGameCounts() {
        return new BaseballGameCounts();
    }

    public boolean isWinCondition() {
        return this.strikes == 3;
    }

    public void showCounts() {

    }

    public void editMessage(String frag) {
        this.message += frag;
    }
}
