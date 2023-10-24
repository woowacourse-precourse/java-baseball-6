package baseball.logic;

import baseball.locales.GameScripts;

public record BaseballResult(
        int strike,
        int ball,
        boolean isSuccess
) {
    public static BaseballResult allStrike(int strike) {
        return new BaseballResult(strike, 0, true);
    }

    public static BaseballResult strikeAndBall(int strike, int ball) {
        return new BaseballResult(strike, ball, false);
    }


    public void printSuccess() {
        System.out.println(strike + GameScripts.GAME_SUCCESS);
    }

    public void printStatus() {
        if (ball == 0 && strike == 0) {
            printNothing();
        }
        if (ball != 0) {
            printBall();
            System.out.print(" ");
        }
        if (strike != 0) {
            printStrike();
        }

        System.out.println();
    }

    private void printNothing() {
        System.out.print(GameScripts.RESULT_NOTHING);
    }

    private void printBall() {
        System.out.print(ball + GameScripts.RESULT_BALL);
    }

    private void printStrike() {
        System.out.print(strike + GameScripts.RESULT_STRIKE);
    }


}
