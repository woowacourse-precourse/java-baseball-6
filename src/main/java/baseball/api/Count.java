package baseball.api;

public class Count {
    private int strikeCount = 0;
    private int ballCount = 0;

    public void incrementStrikeCount(){
        strikeCount++;
    }
    public void incrementBallCount(){
        ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
    public int getBallCount() {
        return ballCount;
    }
}
