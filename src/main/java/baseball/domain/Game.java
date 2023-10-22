package baseball.domain;

public class Game {
    int ballCount;
    int strikeCount;

    int[] gameRandomNumber;

    public void setRandomNumber(int[] gameRandomNumber) {
        this.gameRandomNumber = gameRandomNumber;
    }

    public int[] getGameRandomNumber() {
        return this.gameRandomNumber;
    }

    public void setCountZero() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void addBallCount() {
        this.ballCount += 1;
    }

    public void addStrikeCount() {
        this.strikeCount += 1;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }
}
