package baseball.game;

import static baseball.Constants.ANSWER;
import static baseball.Constants.BALL;
import static baseball.Constants.NOTHING;
import static baseball.Constants.STRIKE;

public class Mention {
    private BallAndStrike ballAndStrike;
    private Result result;

    public Mention(Result result, BallAndStrike ballAndStrike) {
        this.ballAndStrike = ballAndStrike;
        this.result = result;
    }

    public String getMention() {
        if (result == Result.ANSWER) {
            return ANSWER;
        }
        if (result == Result.NOTHING) {
            return NOTHING;
        }
        Integer ball = ballAndStrike.getBall();
        Integer strike = ballAndStrike.getStrike();
        StringBuilder mentionBuilder = new StringBuilder();
        if (ball > 0) {
            mentionBuilder.append(ball).append(BALL);
        }
        if (strike > 0) {
            if (mentionBuilder.length() > 0) {
                mentionBuilder.append(" ");
            }
            mentionBuilder.append(strike).append(STRIKE);
        }
        return mentionBuilder.toString();
    }
}
