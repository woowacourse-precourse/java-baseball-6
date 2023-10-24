package baseball.util;

public class GameUtil {

    private int ballCount = 0;
    private int strikeCount = 0;

    public void computeCount(String computerNumber, String playerNumber) {
        this.strikeCount = computeStrikeCount(computerNumber, playerNumber);
        this.ballCount = computeBallCount(computerNumber, playerNumber);
    }

    private int computeStrikeCount(String computerNumber, String playerNumber) {

        return 0;
    }

    private int computeBallCount(String computerNumber, String playerNumber) {

        return 0;
    }
}
