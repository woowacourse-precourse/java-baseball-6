package baseball.api;

public class Count {
    int strikeCount = 0;
    int ballCount = 0;

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
