package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.domain.BaseballFlag.*;

public class BaseballResult {

    private static Map<BaseballFlag, Integer> transResult = new HashMap<>() {{
        put(BALL, 0);
        put(STRIKE, 0);
        put(NOTHING, 0);
    }};

    public static Map<BaseballFlag, Integer> generate(List<BaseballFlag> gameResult) {
        for (BaseballFlag baseballFlag : gameResult) {
            transResult.put(baseballFlag, transResult.get(baseballFlag) + 1);
        }

        return transResult;
    }
}
