package baseball.domain;

public class RoundResult {
    private int ballCount;
    private int strikeCount;

    public RoundResult(int ballCount, int strikeCount){
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isOnlyStrike(){
        return (strikeCount != 0 && ballCount == 0);
    }

    public boolean isOnlyBall(){
        return (strikeCount == 0 && ballCount != 0);
    }

    public boolean isNothing(){
        return (strikeCount == 0 && ballCount == 0);
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
