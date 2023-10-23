package baseball.domain;

public class RoundResult {
    private int ballCount;
    private int strikeCount;
    private static final int MAX_COUNT = 3;
    private static final int NO_COUNT = 0;

    public RoundResult(int strikeCount, int ballCount){
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isOnlyStrike(){
        return (strikeCount != NO_COUNT && ballCount == NO_COUNT);
    }

    public boolean isOnlyBall(){
        return (strikeCount == MAX_COUNT && ballCount != MAX_COUNT);
    }

    public boolean isNothing(){
        return (strikeCount == NO_COUNT && ballCount == NO_COUNT);
    }

    public boolean isBothOccured(){
        return !(strikeCount == NO_COUNT) && !(ballCount == NO_COUNT);
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isWin(){
        return strikeCount == 3;
    }
}
