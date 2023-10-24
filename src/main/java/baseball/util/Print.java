package baseball.util;

import baseball.constant.MessageConstant;

public class Print {

    public static void showIntro() {
        System.out.println(MessageConstant.INTRO_MESSAGE.message);
    }

    public static void showPredictUserInput() {
        System.out.print(MessageConstant.REQUIRE_USER_INPUT.message);
    }

    public static void showPredictResult(int strike, int ball) {
        if (isNothing(strike, ball)) {
            System.out.println(MessageConstant.NOTHING.message);
        }
        if (isNoStrike(strike, ball)) {
            System.out.println(ball + MessageConstant.BALL.message);
        }
        if (isNoBall(strike, ball)) {
            System.out.println(strike + MessageConstant.STRIKE.message);
        }
        if (isStrikeAndBall(strike, ball)) {
            System.out.println(ball + MessageConstant.BALL.message + " " + strike + MessageConstant.STRIKE.message);
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
        System.out.println(MessageConstant.GAME_OVER.message);
    }

    public static void showRestartOrExitInput() {
        System.out.println(MessageConstant.RESTART_OR_EXIT.message);
    }
}
