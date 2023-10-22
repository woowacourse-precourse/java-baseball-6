package baseball.version2.view;

import static baseball.version2.Constants.Phrases.*;
import static baseball.version2.Constants.Value.THREE_STRIKE;

import baseball.version2.dto.ScoreDto;

public class OutView {

    public void printStart() {
        System.out.println(START_PHRASES);
    }

    public int printResult(ScoreDto scoreDto) {
        int ball = scoreDto.getBall();
        int strike = scoreDto.getStrike();
        if (ball == 0 && strike == 0) {
            printNothing();
        }
        if (ball == 0 && strike > 0) {
            printStrike(strike);
            if (strike == THREE_STRIKE) {
                printThreeStrike();
            }
        }
        if (ball > 0 && strike == 0) {
            printBall(ball);
        }
        if (ball > 0 && strike > 0) {
            printBallAndStrike(ball, strike);
        }
        return strike;
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
