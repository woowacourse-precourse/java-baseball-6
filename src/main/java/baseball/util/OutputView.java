package baseball.util;

import baseball.service.GameResult;

public class OutputView {


    public static void printResult(GameResult result) {

        String msg = "";
        if (result.getNothing() > 0) {
            System.out.println("낫싱");
            return;
        }
        if (result.getBall() > 0) {
            msg += result.getBall() + "볼 ";
        }

        if (result.getStrike() > 0) {
            msg += result.getStrike() + "스트라이크";
        }
        System.out.println(msg);

    }



}
