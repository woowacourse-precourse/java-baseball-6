package baseball.model;

import java.util.Arrays;
import java.util.EnumMap;

public class BaseballGameResult {

    private final EnumMap<BaseballGameResultType, Integer> resultTypeCounts;

    public BaseballGameResult() {
        resultTypeCounts = new EnumMap<>(BaseballGameResultType.class);
        Arrays.stream(BaseballGameResultType.values())
                .forEach(type -> resultTypeCounts.put(type, 0));
    }

    public void add(BaseballGameResultType type) {
        resultTypeCounts.put(type, resultTypeCounts.get(type) + 1);
    }

    @Override
    public String toString() {
        return resultTypeCounts.toString();
    }
}
