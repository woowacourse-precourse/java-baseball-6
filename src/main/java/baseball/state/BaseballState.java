package baseball.state;

import baseball.util.Assertions;
import baseball.util.BooleanUtil;
import java.util.Arrays;
import java.util.List;

public class BaseballState {
    /**
     * indexMapping[value] = index of value
     */
    private final int[] indexMapping;
    private final List<Integer> state;

    public BaseballState(List<Integer> _state) {
        state = _state;

        indexMapping = new int[10];
        Arrays.fill(indexMapping, -1);

        for (int i = 0; i < state.size(); i++) {
            int value = state.get(i);
            Assertions.assertInRange(value, 0, indexMapping.length);
            indexMapping[value] = i;
        }
    }

    List<Integer> get() {
        return state;
    }

    public BaseballResult diff(BaseballState other) {
        int ball = 0;
        int strike = 0;

        final var otherState = other.get();
        for (int i = 0; i < otherState.size(); i++) {
            final int otherValue = otherState.get(i);

            strike += BooleanUtil.booleanToInt(indexMapping[otherValue] == i);
            ball += BooleanUtil.booleanToInt(indexMapping[otherValue] != i && indexMapping[otherValue] != -1);

        }
        return new BaseballResult(ball, strike);
    }
}
