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

    private Boolean hasHint(Hint hint) {
        return this.score.get(hint) > 0;
    }

    private Integer countHint(Hint hint) {
        return this.score.get(hint);
    }

    private Boolean hasNotThing() {
        return score.keySet().stream().noneMatch(this::hasHint);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (hasNotThing()) {
            builder.append(NOT_THING);
        }
        if (hasHint(BALL)) {
            builder.append(countHint(BALL)).append(BALL).append(BLANK);
        }
        if (hasHint(STRIKE)) {
            builder.append(countHint(STRIKE)).append(STRIKE);
        }
        return builder.toString();
    }
}
