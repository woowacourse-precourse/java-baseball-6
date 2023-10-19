package baseball.state;

import java.util.Arrays;
import java.util.List;

public class BaseballState {
    /**
     * indexMapping[value] = index of value
     */
    private final int[] indexMapping;
    private final List<Integer> state;

    public BaseballState(List<Integer> _state) {
        indexMapping = new int[10];
        state = _state;
        Arrays.fill(indexMapping, -1);
        for (int i = 0; i < state.size(); i++) {
            int value = state.get(i);
            if (value < 0 || value >= indexMapping.length) {
                throw new IndexOutOfBoundsException();
            }
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
            if (indexMapping[otherValue] == i) {
                strike++;
            }
            if (indexMapping[otherValue] != i && indexMapping[otherValue] != -1) {
                ball++;
            }
        }
        return new BaseballResult(ball, strike);
    }
}
