package baseball.domain;

public class Game {
    int strikeCount;
    int ballCount;
    int[] gameNumbers;

    public Game(int[] numbers) {
        gameNumbers = numbers;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int[] getGameNumbers() {
        return gameNumbers;
    }

    public void addStrikeCount() {
        strikeCount += 1;
    }

    public void addBallCount() {
        ballCount += 1;
    }

    public void init() {
        strikeCount = 0;
        ballCount = 0;
    }
}
