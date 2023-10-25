package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.domain.BaseballFlag.*;

public class BaseballResult {

    private Map<BaseballFlag, Integer> transResult = new HashMap<>() {{
        put(BALL, 0);
        put(STRIKE, 0);
        put(NOTHING, 0);
    }};

    public void translate(List<BaseballFlag> gameResult) {
        for (BaseballFlag baseballFlag : gameResult) {
            transResult.put(baseballFlag, transResult.get(baseballFlag) + 1);
        }
    }

    public String getResultMessage() {
        if (transResult.get(NOTHING) == 3) {
            return "낫싱";
        }
        if (transResult.get(BALL) == 0 && transResult.get(STRIKE) != 0) {
            return transResult.get(STRIKE) + "스트라이크";
        }
        if (transResult.get(BALL) != 0 && transResult.get(STRIKE) == 0) {
            return transResult.get(BALL) + "볼";
        }
        return transResult.get(BALL) + "볼 " + transResult.get(STRIKE) + "스트라이크";
    }

    public Map<BaseballFlag, Integer> getTransResult() {
        return transResult;
    }
}
