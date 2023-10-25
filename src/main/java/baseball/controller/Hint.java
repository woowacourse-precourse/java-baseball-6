package baseball.controller;

import static baseball.model.TargetNum.TARGET_LENGTH;
import baseball.view.Output;

public class Hint {
    private static int strike, ball;
    public static Boolean isAnswer = false;

    public static void doBaseBall(int[] targetNum, int[] userNum) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < TARGET_LENGTH; i++) {
            int value = userNum[i];
            checkContain(value, targetNum, i);
        }

        if (strike == 3) {
            isAnswer = true;
        }

        if(ball > 0 || strike > 0) {
            Output.hintMessage(ball, strike);
        }
        else{
            Output.hintMessage();
        }
    }

    private static void checkContain(int value, int[] targetNum, int value_index) {
        for (int i = 0; i < TARGET_LENGTH; i++) {
            if (value == targetNum[i]) {
                checkIndex(i, value_index);
            }
        }
    }

    private static void checkIndex(int target_index, int value_index) {
        if (target_index == value_index) {
            strike++;
        }
        else {
            ball++;
        }
    }
}
