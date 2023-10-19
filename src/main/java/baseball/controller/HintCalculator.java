package baseball.controller;

import java.util.List;

public class HintCalculator {
    private final static int LIST_SIZE = 3;
    private int strikeCnt = 0;
    private int ballCnt = 0;


    public HintCalculator(List<Integer> userList, List<Integer> computerList) {
        for (int i = 0; i < LIST_SIZE; ++i) {
            if (isStrike(userList.get(i), computerList.get(i))) {
                ++strikeCnt;
            } else if (isBall(userList.get(i), computerList)) {
                ++ballCnt;
            }
        }
    }

    private boolean isStrike(Integer userNumber, Integer computerNumber) {
        return userNumber == computerNumber;
    }

    private boolean isBall(Integer userNumber, List<Integer> computerList) {
        return computerList.contains(userNumber);
    }

}
