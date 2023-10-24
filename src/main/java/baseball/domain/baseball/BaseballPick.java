package baseball.domain.baseball;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static baseball.domain.baseball.BaseballConst.*;

public class BaseballPick {

    private final List<Integer> picks;

    public BaseballPick(List<Integer> picks) {
        BaseballValidator.validateUserPick(picks);
        this.picks = picks;
    }

    public Integer get(final int index) {
        return picks.get(index);
    }

    public List<Integer> getPicks() {
        return Collections.unmodifiableList(picks);
    }

    public boolean isContain(final Integer value) {
        return picks.contains(value);
    }

    public BaseballResult match(final BaseballPick other) {
        BaseballResult result = new BaseballResult(0, 0);
        for (int i = 0; i < NUMBER_SIZE; i++) {
            boolean isExist = this.isContain(other.get(i));
            boolean isRightOrder = Objects.equals(this.get(i), other.get(i));

            if (isExist && isRightOrder) result.addStrike();
            else if (isExist) result.addBall();

        }
        return result;
    }

}
