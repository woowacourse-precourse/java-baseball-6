package baseball.model;

import baseball.constant.Hint;
import baseball.constant.Number;

import java.util.Map;

import static baseball.constant.Hint.BALL;
import static baseball.constant.Hint.STRIKE;

public class Score {

    private static final String NOTHING = "낫싱";

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

    private Integer count(Hint hint) {
        return this.score.get(hint);
    }

    private Boolean hasNothing() {
        return score.keySet().stream().noneMatch(this::hasHint);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (hasNothing()) {
            builder.append(NOTHING);
        }
        if (hasHint(BALL)) {
            builder.append(count(BALL)).append(BALL);
        }
        if (hasHint(STRIKE)) {
            builder.append(count(STRIKE)).append(STRIKE);
        }
        return builder.toString();
    }
}
