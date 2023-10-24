package baseball.version2.view;

import static baseball.version2.constants.Phrases.BALL_PHRASES;
import static baseball.version2.constants.Phrases.NOTHING_PHRASES;
import static baseball.version2.constants.Phrases.START_PHRASES;
import static baseball.version2.constants.Phrases.STRIKE_PHRASES;
import static baseball.version2.constants.Phrases.THREE_STRIKE_PHRASES;
import static baseball.version2.constants.Value.THREE_STRIKE;

import baseball.version2.object.Score;

public class OutView {
    public void printStart() {
        System.out.println(START_PHRASES);
    }

    public int printResult(Score score) {
        int ball = score.getBall();
        int strike = score.getStrike();

        if (ball == 0 && strike == 0) {
            printNothing();
        }
        if (ball == 0 && strike > 0) {
            printStrike(strike);
            checkThreeStrike(strike);
        }
        if (ball > 0 && strike == 0) {
            printBall(ball);
        }
        if (ball > 0 && strike > 0) {
            printBallAndStrike(ball, strike);
        }
        return strike;
    }

    private void checkThreeStrike(int strike) {
        if (strike == THREE_STRIKE) {
            printThreeStrike();
        }
    }

    private void printThreeStrike() {
        System.out.println(THREE_STRIKE_PHRASES);
    }

    private void printNothing() {
        System.out.println(NOTHING_PHRASES);
    }

    private void printBall(int ball) {
        System.out.println(ball + BALL_PHRASES);
    }

    private void printStrike(int strike) {
        System.out.println(strike + STRIKE_PHRASES);
    }

    private void printBallAndStrike(int ball, int strike) {
        System.out.println(ball + BALL_PHRASES + " " + strike + STRIKE_PHRASES);
    }
}
