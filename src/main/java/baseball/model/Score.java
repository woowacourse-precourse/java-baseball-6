package baseball.model;

import baseball.constant.Hint;
import baseball.constant.Number;

import java.util.Map;

import static baseball.constant.Hint.BALL;
import static baseball.constant.Hint.STRIKE;

public class Score {

    public final String BALL_MESSAGE = "볼 ";
    public final String NOT_THING = "낫싱";
    public final String STRIKE_MESSAGE = "스트라이크";

    private final Map<Hint, Integer> score;

    public Score(Map<Hint, Integer> score) {
        this.score = score;
    }

    public Boolean isStrikeOut() {
        if (score == null) {
            return false;
        }
        return score.get(STRIKE).equals(Number.SIZE);
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
            builder.append(countHint(BALL)).append(BALL_MESSAGE);
        }
        if (hasHint(STRIKE)) {
            builder.append(countHint(STRIKE)).append(STRIKE_MESSAGE);
        }
        return builder.toString();
    }
}
