package baseball.domain;

public class GameSystem {
    private int roundNumber;
    private int strike;
    private int ballCount;

    public GameSystem() {
        this.roundNumber = 0;
        this.strike = 0;
        this.ballCount = 0;
    }


    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }
}
