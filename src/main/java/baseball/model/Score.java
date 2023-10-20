package baseball.model;

import baseball.constant.Hint;

import java.util.Map;

import static baseball.constant.Hint.BALL;
import static baseball.constant.Hint.BLANK;
import static baseball.constant.Hint.NOT_THING;
import static baseball.constant.Hint.STRIKE;

public class Score {

    private final Map<Hint, Integer> score;

    public Score(Map<Hint, Integer> score) {
        this.score = score;
    }

    public Boolean isStrikeOut() {
        return score.get(STRIKE).equals(3);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (score.get(STRIKE) == 0 && score.get(BALL) == 0) {
            builder.append(NOT_THING);
        }
        if (score.get(BALL) > 0) {
            builder.append(score.get(BALL)).append(BALL).append(BLANK);
        }
        if (score.get(STRIKE) > 0) {
            builder.append(score.get(STRIKE)).append(STRIKE);
        }
        return builder.toString();
    }
}
