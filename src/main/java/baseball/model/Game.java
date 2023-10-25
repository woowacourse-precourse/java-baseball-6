package baseball.model;

public class Game {
    int strikeCount;
    int ballCount;
    int[] gameNumbers;

    public Game(int[] numbers) {
        gameNumbers = numbers;
    }
    public void initBaseBall() {
        strikeCount = 0;
        ballCount = 0;
    }
    public int getStrikeCount() {
        return strikeCount;
    }
    public int getBallCount() {
        return ballCount;
    }
    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }
    public int[] getGameNumbers() {
        return gameNumbers;
    }
    public void incStrikeCount() {
        strikeCount += 1;
    }
    public void incBallCount() {
        ballCount += 1;
    }
}
