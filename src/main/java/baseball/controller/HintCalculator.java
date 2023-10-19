package baseball.controller;

import java.util.List;

public class HintCalculator {
    private final static int LIST_SIZE = 3;
    private int strikeCnt = 0;
    private int ballCnt = 0;


    public HintCalculator(List<Integer> userNumber, List<Integer> computerNumber) {
        for (int i = 0; i < LIST_SIZE; ++i) {
            if (isStrike(userNumber.get(i), computerNumber.get(i))) {
                ++strikeCnt;
            } else if (isBall(userNumber.get(i), computerNumber.get(i))) {
                ++ballCnt;
            }
        }
    }

    private boolean isStrike(Integer userDigit, Integer computerDigit) {
        return userDigit == computerDigit;
    }

    private boolean isBall(Integer integer, Integer integer1) {
        return false;
    }

}
