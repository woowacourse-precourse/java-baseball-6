package baseball.domain;

import java.util.EnumMap;
import java.util.Map;

public class BaseballResult {
    private final Map<BaseballResultState, Integer> resultState;


    public BaseballResult() {
        resultState = new EnumMap<BaseballResultState, Integer>(BaseballResultState.class);

        for (BaseballResultState baseballResultState : BaseballResultState.values()) {
            resultState.put(baseballResultState, 0);
        }
    }

    public void incrementCount(BaseballResultState baseballResultState) {
        int count = resultState.get(baseballResultState);
        resultState.put(baseballResultState, count + 1);
    }

    public int getCount(BaseballResultState baseballResultState) {
        return resultState.get(baseballResultState);
    }

}
