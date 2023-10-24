package baseball.util;

public class GameUtil {

    private int ballCount = 0;
    private int strikeCount = 0;
    private static final int NUMBER_LENGTH = 3;

    public void computeCount(String computerNumber, String playerNumber) {
        this.strikeCount = computeStrikeCount(computerNumber, playerNumber);
        this.ballCount = computeBallCount(computerNumber, playerNumber);
    }

    private int computeStrikeCount(String computerNumber, String playerNumber) {

        return 0;
    }

    private int computeBallCount(String computerNumber, String playerNumber) {
        int ball = 0;

        for (int playerIndex = 0; playerIndex < NUMBER_LENGTH; playerIndex++) {
            char target =  playerNumber.charAt(playerIndex);
            int computerIndex = computerNumber.indexOf(target);

            if (computerIndex != -1 && computerIndex != playerIndex) {
                ball++;
            }
        }

        return ball;
    }
}
