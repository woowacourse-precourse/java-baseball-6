package baseball.domain.scoringnumbers;

import baseball.system.SystemConstant;

public class Strikes extends ScoringNumbers {
    public Strikes(int value) {
        super(value);
    }

    public Strikes(long value) {
        super((int) value);
    }

    public boolean isStrikeAllOfBalls() {
        return super.value == SystemConstant.MAXIMUM_DIGIT;
    }
}
