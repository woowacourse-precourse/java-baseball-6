package utils;

import static constant.Constant.*;


public class Printer {

    public static void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING_STRING);
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + BALL_STRING);
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + STRIKE_STRING);
        }
        if (ball != 0 && strike != 0)
            System.out.println(ball + BALL_STRING + " " + strike + STRIKE_STRING);
    }

    public static void printSuccess() {
        System.out.println(SUCCESS_MESSAGE + " " + END_MESSAAGE);
    }
}

