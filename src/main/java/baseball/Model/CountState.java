package baseball.Model;

public class CountState {
    private int strikeCount;
    private int ballCount;

    public CountState() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void countingStrike() {
        ++strikeCount;
    }

    public void countingBall() {
        ++ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount(){
        return ballCount;
    }
}
