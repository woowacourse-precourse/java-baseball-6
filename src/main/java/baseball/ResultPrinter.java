package baseball;

import java.util.List;

public class ResultPrinter {

    private static final int DEFAULT_SIZE = 3;
    private static final int STRIKE_IDX = 0;
    private static final int BALL_IDX = 1;
    private static final int NOTHING_IDX = 2;

    public void printResult(List<Integer> results) {
        if (printNothing(results)) return;
        printBall(results);
        if (results.get(BALL_IDX) != 0 && results.get(STRIKE_IDX) != 0) {
            System.out.print(" ");
        }
        printStrike(results);
    }

    public static void printStrike(List<Integer> results) {
        if (results.get(STRIKE_IDX) != 0) {
            System.out.print(results.get(STRIKE_IDX) + "스트라이크");
        }
    }

    public static void printBall(List<Integer> results) {
        if (results.get(BALL_IDX) != 0) {
            System.out.print(results.get(BALL_IDX) + "볼");
        }
    }

    public static boolean printNothing(List<Integer> results) {
        if (results.get(NOTHING_IDX) == DEFAULT_SIZE) {
            System.out.print("낫싱");
            return true;
        }
        return false;
    }
}
