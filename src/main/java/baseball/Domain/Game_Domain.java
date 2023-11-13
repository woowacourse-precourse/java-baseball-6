package baseball.Domain;

public class Game_Domain {
    int strikeCount;
    int ballCount;
    int[] gameNumbers;

    public Game_Domain(int[] numbers) {
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