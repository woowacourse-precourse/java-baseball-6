package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class GameNumberValidateService {

    private static final int NUMBER_LENGTH = 3;

    private int ballCount;
    private int strikeCount;
    private List<Integer> ballAndStrikeCountList = new ArrayList<>();

    public List<Integer> calculateGameNumber(String computerGameNumber, String playerNumber) {
        ballCount = calculateBallCount(computerGameNumber, playerNumber);
        strikeCount = calculateStrikeCount(computerGameNumber, playerNumber);
        setBallAndStrikeCountList(ballCount, strikeCount);

        return ballAndStrikeCountList;
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

    private int calculateStrikeCount(String computerGameNumber, String playerNumber) {
        for (int place = 0; place < NUMBER_LENGTH; place++) {
            if (isStrikeCheck(computerGameNumber.charAt(place), playerNumber.charAt(place))){
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean isStrikeCheck(char computerPlaceNumber, char playerPlaceNumber) {
        return computerPlaceNumber == playerPlaceNumber;
    }
    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setBallAndStrikeCountList(int ballCount, int strikeCount) {
        ballAndStrikeCountList.add(ballCount);
        ballAndStrikeCountList.add(strikeCount);
    }
}
