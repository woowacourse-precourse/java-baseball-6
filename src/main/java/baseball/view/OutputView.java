package baseball.view;

import baseball.util.ResultMessage;

public class OutputView {
    public static void printConsoleMessage(String message) {
        System.out.print(message);
    }

    public static void printlnConsoleMessage(String message) {
        System.out.println(message);
    }

    public static void printGameResult(int strikes, int balls) {
        hasBallsAndStrikes(strikes, balls);
        hasOnlyStrikes(strikes, balls);
        hasOnlyBalls(strikes, balls);
        hasNothing(strikes, balls);
    }

    private static void hasNothing(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println(ResultMessage.NOTHING);
        }
    }

    private static void hasOnlyStrikes(int strikes, int balls) {
        if (strikes > 0 && balls == 0) {
            System.out.printf(ResultMessage.STRIKE_COUNT, strikes);
        }
    }

    private static void hasOnlyBalls(int strikes, int balls) {
        if (strikes == 0 && balls > 0) {
            System.out.printf(ResultMessage.BALL_COUNT, balls);
        }
    }

    private static void hasBallsAndStrikes(int strikes, int balls) {
        if (strikes > 0 && balls > 0) {
            System.out.printf(ResultMessage.BALL_AND_STRIKE_COUNT, strikes, balls);
        }
    }
}
