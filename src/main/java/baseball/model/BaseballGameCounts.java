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
        if (message.isEmpty()) {
            System.out.println("낫싱");
        } else {
            System.out.println(message);
        }
    }

    public void editMessage(String frag) {
        this.message += frag;
    }
}
