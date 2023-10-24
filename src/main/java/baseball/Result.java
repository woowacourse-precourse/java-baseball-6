package baseball;

import static baseball.Constants.NUMBER_LENGTH;
import static baseball.Constants.WHITE_SPACE;

public class Result {

    private int ball;
    private int strike;

    private Result() {
        ball = 0;
        strike = 0;
    }

    public static Result getInstance() {
        return new Result();
    }

    public void addStrike() {
        strike++;
    }

    public void addBall() {
        ball++;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public void ballMessage(StringBuilder message) {
        if (ball > 0) {
            message.append(ball);
            message.append(Inning.BALL.getMessage());
        }
    }

    public void whiteSpaceMessage(StringBuilder message) {
        if (ball > 0 && strike > 0) {
            message.append(WHITE_SPACE);
        }
    }

    public void strikeMessage(StringBuilder message) {
        if (strike > 0) {
            message.append(strike);
            message.append(Inning.STRIKE.getMessage());
        }
    }

    public boolean isThreeStrikes() {
        return strike == NUMBER_LENGTH;
    }

}
