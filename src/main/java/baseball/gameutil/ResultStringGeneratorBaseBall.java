package baseball.gameutil;

import baseball.message.MessageString;

public class ResultStringGeneratorBaseBall implements ResultStringGenerator {

    public String result(Score score) {
        if (score.getBall() == 0 && score.getStrike() == 0) {
            return MessageString.NOTHING_MSG;
        }
        return "%s %s"
            .formatted(ballStringBuilder(score.getBall()), strikeStringBuilder(score.getStrike()))
            .trim();
    }

    private String strikeStringBuilder(Integer strike) {
        if (strike == 0) {
            return "";
        }
        return "%d%s".formatted(strike, MessageString.STRIKE_MSG);
    }

    private String ballStringBuilder(Integer ball) {
        if (ball == 0) {
            return "";
        }
        return "%d%s".formatted(ball, MessageString.BALL_MSG);
    }

}