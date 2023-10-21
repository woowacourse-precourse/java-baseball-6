package baseball.state;

import static baseball.constant.BaseballConstants.MAX_DIGIT;
import static baseball.constant.BaseballConstants.MAX_MATCH;

import baseball.util.Assertions;
import java.util.Arrays;

public class BaseballStateMatchHelper {
    private final int[] indexMatcher;

    public BaseballStateMatchHelper(BaseballState state) {
        indexMatcher = new int[MAX_DIGIT + 1];
        Arrays.fill(indexMatcher, -1);
        for (int i = 0; i < MAX_MATCH; i++) {
            var value = state.nth(i);
            Assertions.assertInRange(value, 0, MAX_DIGIT);
            indexMatcher[value] = i;
        }
    }

    public boolean checkStrike(int idx, int value) {
        return indexMatcher[value] == idx;
    }

    public boolean checkBall(int idx, int value) {
        return indexMatcher[value] != -1 && !checkStrike(idx, value);
    }
}
