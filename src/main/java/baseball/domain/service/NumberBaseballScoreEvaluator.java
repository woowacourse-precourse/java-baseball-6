package baseball.domain.service;

import baseball.domain.model.ScoreMessage;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballScoreEvaluator {

    public String evaluate(BaseballScoreCounter baseballScoreCounter) {
        int strikes = baseballScoreCounter.countStrikes();
        int balls = baseballScoreCounter.countBalls();
        return formatResult(strikes, balls);
    }

    private String formatResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return ScoreMessage.NOTHING.formatMessage(0);
        }

        List<String> messages = new ArrayList<>();

        if (balls > 0) {
            messages.add(ScoreMessage.BALL.formatMessage(balls));
        }

        if (strikes > 0) {
            messages.add(ScoreMessage.STRIKE.formatMessage(strikes));
        }

        return String.join(" ", messages);
    }
}

