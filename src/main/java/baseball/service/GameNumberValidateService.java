package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class GameNumberValidateService {

    private static final int NUMBER_LENGTH = 3;

    private int ballCount;

    public void calculateGameNumber(String computerGameNumber, String playerNumber) {
        ballCount = calculateBallCount(computerGameNumber, playerNumber);
    }

    private int calculateBallCount(String computerGameNumber, String playerNumber) {
        for (int computerPlace = 0; computerPlace < NUMBER_LENGTH; computerPlace++) {
            isBallCheck(computerGameNumber.charAt(computerPlace), computerPlace, playerNumber);
        }

        return ballCount;
    }

    private void isBallCheck(char computerPlaceNumber, int computerPlace, String playerNumber) {
        for (int playerPlace = 0; playerPlace < NUMBER_LENGTH; playerPlace++) {
            if (computerPlaceNumber == playerNumber.charAt(playerPlace) && computerPlace != playerPlace){
                ballCount++;
            }
        }
    }

    public int getBallCount() {
        return ballCount;
    }

}
