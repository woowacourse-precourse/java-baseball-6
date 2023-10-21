package baseball.model;

import java.util.Objects;

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
        System.out.println(Objects.requireNonNullElse(message, "낫싱"));
    }

    public void editMessage(String frag) {
        if (message == null) {
            this.message = frag;
        } else {
            this.message = frag + this.message;
        }
    }

    public void resetCounts() {
        this.message = null;
        this.strikes = 0;
        this.balls = 0;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public String getMessage() {
        return message;
    }
}
