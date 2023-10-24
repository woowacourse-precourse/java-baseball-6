package baseball.domain;

public class Game {
    int[] gameNumbers;
    int strikeCount;
    int ballCount;

    public Game(int[] numbers) {
        gameNumbers = numbers;
    }

    public void initGame() {
        strikeCount = 0;
        ballCount = 0;
    }

    public int[] getGameNumbers() {
        return gameNumbers;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void addStrikeCount() {
        strikeCount += 1;
    }

    public void addBallCount() {
        ballCount += 1;
    }
}
