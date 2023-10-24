package baseball.util;

import baseball.constant.Message;

public class Print {

    public static void showIntro() {
        System.out.println(Message.INTRO_MESSAGE.message);
    }

    public static void showPredictUserInput() {
        System.out.print(Message.REQUIRE_USER_INPUT.message);
    }

    public static void showPredictResult(int strike, int ball) {
        if (isNothing(strike, ball)) {
            System.out.println(Message.NOTHING.message);
        }
        if (isNoStrike(strike, ball)) {
            System.out.println(ball + Message.BALL.message);
        }
        if (isNoBall(strike, ball)) {
            System.out.println(strike + Message.STRIKE.message);
        }
        if (isStrikeAndBall(strike, ball)) {
            System.out.println(ball + Message.BALL.message + " " + strike + Message.STRIKE.message);
        }
    }

    private static boolean isStrikeAndBall(int strike, int ball) {
        return strike != 0 && ball != 0;
    }

    private static boolean isNoBall(int strike, int ball) {
        return strike != 0 && ball == 0;
    }

    private static boolean isNoStrike(int strike, int ball) {
        return strike == 0 && ball != 0;
    }

    private static boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    public static void showGameOver() {
        System.out.println(Message.GAME_OVER.message);
    }

    public static void showRestartOrExitInput() {
        System.out.println(Message.RESTART_OR_EXIT.message);
    }
}
