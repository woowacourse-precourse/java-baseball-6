package baseball;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private final Map<CompareStatus, Integer> result = new EnumMap<>(CompareStatus.class);

    public int get(CompareStatus compareStatus) {
        return result.getOrDefault(compareStatus, 0);
    }

    public void set(CompareStatus compareStatus, int compareCount) {
        result.put(compareStatus, compareCount);
    }

    public boolean hasThreeStrike() {
        return result.getOrDefault(CompareStatus.STRIKE, 0) == 3;
    }
}
