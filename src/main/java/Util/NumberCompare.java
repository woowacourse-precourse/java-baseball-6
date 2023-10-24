package Util;

import Model.BaseballNumberConstants;
import java.util.HashMap;
import java.util.Map;

public class NumberCompare {

    private int ball;
    private int strike;

    public Map<String, Integer> getNumberCount(String computerNumber, String userNumber) {
        resetCount();
        ballCount(computerNumber, userNumber);
        strikeCount(computerNumber, userNumber);
        resultCount();
        return createResultMap();
    }

    private void resetCount() {
        ball = 0;
        strike = 0;
    }

    private void ballCount(String computerNumber, String userNumber) {
        for (int i = 0; i < BaseballNumberConstants.INPUT_MAX_COUNTS; i++) {
            if (computerNumber.contains(Character.toString(userNumber.charAt(i)))) {
                ball++;
            }
        }
    }

    private void strikeCount(String computerNumber, String userNumber) {
        for (int i = 0; i < BaseballNumberConstants.INPUT_MAX_COUNTS; i++) {
            if (computerNumber.charAt(i) == userNumber.charAt(i)) {
                strike++;
            }
        }
    }

    private void resultCount() {
        ball = ball - strike;
    }

    private Map<String, Integer> createResultMap() {
        Map<String, Integer> result = new HashMap<>();
        result.put("BALL", ball);
        result.put("STRIKE", strike);
        return result;
    }
}
