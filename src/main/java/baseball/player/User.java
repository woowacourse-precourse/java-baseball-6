package baseball.player;

import java.util.List;

public class User {
    private List<Integer> number;
    private int strikes;
    private int balls;

    public User(List<Integer> number) {
        this.number = number;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }
}
