package view;

import static model.Constant.BALL;
import static model.Constant.NOTHING;
import static model.Constant.START_MESSAGE;
import static model.Constant.STRIKE;

import java.util.List;

public class OutputView {
    public static void printStartString() {
        System.out.println(START_MESSAGE);
    }

    public static void printAnswer(List<Integer> inputAnswer) {
        System.out.println("answer : " + inputAnswer);
    }

    public static void printResult(int strike, int ball) {
        printBall(ball);
        printStrike(strike);

        if (isNothing(strike, ball)) {
            printNothing();
        }
        System.out.println();
    }

    private static boolean isNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }

    private static void printNothing() {
        System.out.print(NOTHING);
    }

    private static void printBall(int ball) {
        if (ball > 0) {
            System.out.print(ball + BALL);
        }
    }

    private static void printStrike(int strike) {
        if (strike > 0) {
            System.out.print(strike + STRIKE);
        }
    }
}
