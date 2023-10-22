package baseball.model.baseball;

import baseball.util.RandomNumberCreateUtil;

import java.util.Collections;
import java.util.List;

public class BaseballGame {

    private final List<Integer> baseballNumbers;

    public BaseballGame() {
        this.baseballNumbers = RandomNumberCreateUtil.createBaseballNumbers();
    }

    public List<Integer> getBaseballNumbers() {
        return Collections.unmodifiableList(baseballNumbers);
    }

}
