package baseball.view;

import baseball.valueObject.ResultBall;

public class OutputView {
    private static final String MESSAGE_BALL = "볼";
    private static final String MESSAGE_STRIKE = "스트라이크";
    private static final String MESSAGE_SPACE = " ";
    private static final String MESSAGE_NOTHING = "낫싱";
    private static final String NO_MESSAGE = "";
    private static final int ZERO = 0;

    public static void printResult(ResultBall resultBall) {
        int ball = resultBall.getBall();
        int strike = resultBall.getStrike();

        StringBuilder outputBallResult = new StringBuilder();
        outputBallResult.append(getBallMessage(ball));
        outputBallResult.append(getSpaceMessage(ball, strike));
        outputBallResult.append(getStrikeMessage(strike));
        outputBallResult.append(getNothingMessage(ball, strike));

        System.out.println(outputBallResult);
    }

    private static String getNothingMessage(int ball, int strike) {
        if (ball == ZERO && strike == ZERO)
            return MESSAGE_NOTHING;
        return NO_MESSAGE;
    }

    private static String getBallMessage(int ball) {
        if (ball == 0) {
            return NO_MESSAGE;
        }

        return ball + MESSAGE_BALL;
    }

    private static String getStrikeMessage(int strike) {
        if (strike == 0) {
            return NO_MESSAGE;
        }

        return strike + MESSAGE_STRIKE;
    }

    private static String getSpaceMessage(int ball, int strike) {
        if ((ball != 0) && (strike != 0)) {
            return MESSAGE_SPACE;
        }

        return NO_MESSAGE;
    }

}
