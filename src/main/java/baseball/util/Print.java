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
        String resultString = Validation.checkPredict(strike, ball);
        System.out.println(resultString);
    }

    public static void showGameOver() {
        System.out.println(MessageConstant.GAME_OVER.message);
    }

    public static void showRestartOrExitInput() {
        System.out.println(MessageConstant.RESTART_OR_EXIT.message);
    }
}
