package baseball.entity;

public class Ball {
    private int count;

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        this.count++;
    }

    public void resetScore() {
        this.count = 0;
    }
}
