package baseball.model;

public class Strike {
    private int strikeCount;

    public Strike() {
        this.strikeCount = 0;
    }

    public void increaseStrikeCount() {
        this.strikeCount++;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }
}
