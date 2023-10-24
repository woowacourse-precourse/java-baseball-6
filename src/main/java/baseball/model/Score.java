package baseball.model;

public class Score {

    private int ballCount;
    private int strikeCount;

    public Score() {
        ballCount = 0;
        strikeCount = 0;
    }
    public int getBallCount(){
        return ballCount;
    }
    public int getStrikeCount() {
        return strikeCount;
    }
    public void resetScore() {
        strikeCount = 0;
        ballCount = 0;
    }
    public void incStrikeCount() {
        strikeCount += 1;
    }
    public void incBallCount() {
        ballCount += 1;
    }

}
