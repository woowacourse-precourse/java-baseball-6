package ball;

public enum BallStatus {
    STRIKE,
    BALL,
    NOTHING;
    private int strikeCount;
    private int ballCount;

    public void addStrikeCount(){
        this.strikeCount++;
    }

    public void addBallCount(){
        this.ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isNothing(){
        return this.ballCount == 0 && this.strikeCount == 0;
    }
}
