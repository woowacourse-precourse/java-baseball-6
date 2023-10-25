package baseball;

public class Game {
    int strikeCount;
    int ballCount;
    int[] gameNumbers;

    public int getStrikeCount() {
        return strikeCount;
    }

    public Game(int[] gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int[] getGameNumbers() {
        return gameNumbers;
    }

    public void setGameNumbers(int[] gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public void increaseStrikeCount() {
        strikeCount++;
    }

    public void increaseBallCount() {
        ballCount++;
    }

    public void initBaseBall() {
        strikeCount = 0;
        ballCount = 0;

    }
}
