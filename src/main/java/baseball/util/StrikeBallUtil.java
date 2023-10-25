package baseball.util;

import static baseball.constant.Constant.NUMBER_BASEBALL_STR_LENGTH;

import baseball.game.Hint;

public class StrikeBallUtil {

    public static Hint getHint(char[] answerNumbers, char[] userNumbers) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < NUMBER_BASEBALL_STR_LENGTH; i++) {
            char userNumber = userNumbers[i];
            for (int j = 0; j < NUMBER_BASEBALL_STR_LENGTH; j++) {
                char answerNumber = answerNumbers[j];
                if (isSameNumber(userNumber, answerNumber)) {

                    if (isSamePosition(i, j)) {
                        strike++;
                    } else {
                        ball++;
                    }
                    break;
                }
            }
        }

        return new Hint(strike, ball);
    }

    private static boolean isSameNumber(char a, char b) {
        return a == b;
    }

    private static boolean isSamePosition(int a, int b) {
        return a == b;
    }

    public static void printHint(Hint hint) {
        if (isNotThing(hint)) {
            OutputUtil.printNothing();
        } else if (isBallAndStrike(hint)) {
            OutputUtil.printBallAndStrike(hint);
        } else {

            if (isOnlyBall(hint)) {
                OutputUtil.printOnlyBall(hint.getBall());
            } else {
                OutputUtil.printOnlyStrike(hint.getStrike());
            }

        }
    }

    private static boolean isNotThing(Hint hint) {
        return hint.getStrike() == 0 && hint.getBall() == 0;
    }

    private static boolean isBallAndStrike(Hint hint) {
        return hint.getStrike() > 0 && hint.getBall() > 0;
    }

    private static boolean isOnlyBall(Hint hint) {
        return hint.getStrike() == 0 && hint.getBall() > 0;
    }
}
