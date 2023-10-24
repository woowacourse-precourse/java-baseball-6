package baseball.view;

import baseball.domain.BallCount;
import org.w3c.dom.ls.LSOutput;

public class ResultView {
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String STRIKE_AND_BALL_MESSAGE = "%d볼 %d스트라이크";
    private static final String NOTHING = "낫싱";

    public void printResult(BallCount ballCount) {
        if (ballCount.isAllStrike()) {
            System.out.println(printOnlyStrike(ballCount));
        }
        if (ballCount.isStrike()) {
            System.out.println(printOnlyStrike(ballCount));
        }
        if (ballCount.isBall()) {
            System.out.println(printOnlyBall(ballCount));
        }
        if (ballCount.isStrikeAndBall()) {
            System.out.println(printStrikeAndBall(ballCount));
        }
        if (ballCount.isNothing()) {
            System.out.println(printNothing());
        }
    }
    private String printOnlyStrike(BallCount ballCount) {
        return String.format(STRIKE_MESSAGE, ballCount.getStrike());
    }

    private String printOnlyBall(BallCount ballCount) {
        return String.format(BALL_MESSAGE, ballCount.getBall());
    }

    private String printStrikeAndBall(BallCount ballCount) {
        return String.format(STRIKE_AND_BALL_MESSAGE, ballCount.getStrike(), ballCount.getBall());
    }

    private String printNothing() {
        return NOTHING;
    }
}