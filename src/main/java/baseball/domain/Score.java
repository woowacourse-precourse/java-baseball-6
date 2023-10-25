package baseball.domain;

public class Score {

    private int ballCount;
    private int strikeCount;

    public void resetScore() {
        strikeCount = 0;
        ballCount = 0;
    }
    public int getBallCount(){
        return ballCount;
    }
    public int getStrikeCount() {
        return strikeCount;
    }

    public void incStrikeCount() {
        strikeCount += 1;
    }
    public void incBallCount() {
        ballCount += 1;
    }

}
