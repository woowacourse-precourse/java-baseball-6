package baseball.model;

import baseball.constants.Constants;
import java.util.ArrayList;
import java.util.List;

public class StrikeAndBallCounter {

    public int[] getStrikeAndBallCount(List<Integer> computerNumber, String userInputNumber) {

        int[] strikeAndBallCount = new int[2];
        List<Integer> userNumber = setStringToListInteger(userInputNumber);

        for (int index = 0; index < Constants.NUMBER_SIZE; index++) {
            if (computerNumber.get(index) == userNumber.get(index)) {
                strikeAndBallCount[Constants.STRIKE_INDEX]++;
                continue;
            }
            if (computerNumber.contains(userNumber.get(index))) {
                strikeAndBallCount[Constants.BALL_INDEX]++;
            }
        }
        return strikeAndBallCount;
    }

    public List<Integer> setStringToListInteger(String userInputNumber) {
        List<Integer> userNumber = new ArrayList<>();
        for (char digit : userInputNumber.toCharArray()) {
            userNumber.add(Character.getNumericValue(digit));
        }
        return userNumber;
    }

}
