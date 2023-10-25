package baseball.controller;

import baseball.view.Output;

public class Hint {
    public static Boolean isAnswer = false;

    public static void doBaseball(int[] userNum, int[] targetNum) {
        int ballCnt = 0;
        int strikeCnt = 0;

        for (int i = 0; i < userNum.length; i++) {
            int userValue = userNum[i];
            int targetIdx = getTargetIdxIfContain(userValue, targetNum);
            boolean isSameIndex = (i == targetIdx);

            if (targetIdx > -1 && isSameIndex) {
                strikeCnt++;
            }
            if (targetIdx > -1 && !isSameIndex) {
                ballCnt++;
            }
        }

        if (strikeCnt == 3) {
            isAnswer = true;
        }

        Output.resultMessage(ballCnt, strikeCnt);
    }

    private static int getTargetIdxIfContain(int userValue, int[] targetNum) {
        for (int i = 0; i < targetNum.length; i++) {
            if (userValue == targetNum[i]) {
                return i;
            }
        }
        return -1;
    }
}
