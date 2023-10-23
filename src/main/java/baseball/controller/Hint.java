package baseball.controller;

import baseball.model.TargetNum;
import baseball.view.Output;

public class Hint {
    static int strike, ball;
    static Boolean isAnswer = false;

    public static void doBaseBall(int[] targetNum, int[] userNum){
        strike = 0;
        ball = 0;

        for (int i = 0; i < TargetNum.targetLength; i++) {
            int value = userNum[i];
            int value_index = i;
            checkContain(value, targetNum, value_index);
        }
        if (strike == 3){
            isAnswer = true;
        }
        if(ball > 0 || strike > 0){
            Output.message(ball, strike);
        }
        else{
            Output.message();
        }
    }

    private static void checkContain(int value, int[] targetNum, int value_index){
        for (int i = 0; i < TargetNum.targetLength; i++) {
            if (value == targetNum[i]){
                checkIndex(i, value_index);
            }
        }
    }

    private static void checkIndex(int target_index, int value_index) {
        if (target_index == value_index){
            strike++;
        }
        else {
            ball++;
        }
    }
}
