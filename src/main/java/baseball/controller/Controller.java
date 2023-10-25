package baseball.controller;

import java.util.ArrayList;
import java.util.List;


public class Controller {
    private  int strike = 0;
    private  int ball = 0;
    private  int nothing = 0;

    public void check(List<Integer> computer, String input) {
        strike = 0;
        ball = 0;
        nothing = 0;
        char[] input_arr = input.toCharArray();
        for (int i = 0; i < input_arr.length; i++) {
            // 숫자 포함하면
            // 스트라이크 or 볼 확인
            if (computer.contains(Character.getNumericValue(input_arr[i]))) {
                if (checkStrike(computer, Character.getNumericValue(input_arr[i]), i)) {
                    strike++;
                } else {
                    ball++;
                }
            } else {
                nothing++;
            }
        }
    }

    private static boolean checkStrike(List<Integer> computer, int target, int index) {
        if (computer.indexOf(target) == index) {
            return true;
        }else return false;
    }

    public  int getStrike() {
        return strike;
    }

    public  int getBall() {
        return ball;
    }

    public  int getNothing() {
        return nothing;
    }
}
