package baseball.util;

import java.util.StringJoiner;

import static baseball.constant.SystemConstant.*;

public class GameUtil {

    private int ballCount = 0;
    private int strikeCount = 0;

    public void computeCount(String computerNumber, String playerNumber) {
        this.strikeCount = computeStrikeCount(computerNumber, playerNumber);
        this.ballCount = computeBallCount(computerNumber, playerNumber);
    }

    private int computeStrikeCount(String computerNumber, String playerNumber) {
        int strike = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++){
            if (computerNumber.charAt(i) == playerNumber.charAt(i)) {
                strike++;
            }
        }

        return strike;
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

    public String showHint() {
        StringJoiner stringJoiner = new StringJoiner(SPACE);

        if (this.ballCount > 0) {
            stringJoiner.add(String.format(BALL, this.ballCount));
        }

        if (this.strikeCount > 0) {
            stringJoiner.add(String.format(STRIKE, this.strikeCount));
        }

        if (this.ballCount == 0 && this.strikeCount == 0) {
            stringJoiner.add(NOTHING);
        }

        return stringJoiner.toString();
    }

    public boolean checkGameOver() {
        return this.strikeCount == NUMBER_LENGTH;
    }
}
