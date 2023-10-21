package View;

import Constant.Ment;

public class GameResult {
    //수정
    public static void PrintResult(int strike, int ball, boolean judge) {
        if (judge) {
            System.out.println(Ment.getNothing());
            return;
        }
        System.out.println(strike + Ment.getStrike() + ball + Ment.getBall());
    }
}
