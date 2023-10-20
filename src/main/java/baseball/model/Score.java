package baseball.model;

import baseball.constant.Hint;
import baseball.constant.Number;

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
        if (score == null) {
            return false;
        }
        return score.get(STRIKE).equals(Number.OUT_COUNT);
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
