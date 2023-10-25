package baseball.controller;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private int strike;
    private int ball;
    public void numberAnalysis(String computerNum, String userNum) {
        countStrikeBall(computerNum, userNum);
    }

    public boolean isThreeStrike (String computerNum, String userNum) {
        return computerNum.equals(userNum);
    }

    public void countStrikeBall(String computerNum, String userNum) {
        strike = 0;
        ball = 0;

        if (isThreeStrike(computerNum, userNum)) {
            strike = 3;
            return ;
        }

        for (int i = 0; i < 3; i++) {
            char checkNum = userNum.charAt(i);
            if (computerNum.charAt(i) == checkNum)
                strike++;
            else if (computerNum.contains(String.valueOf(checkNum))) {
                ball++;
            }
        }
    }
    Map<String, Integer> getResult() {
        Map<String, Integer> countResult = new HashMap<>();
        countResult.put("strike", strike);
        countResult.put("ball", ball);
        return countResult;
    }
}
