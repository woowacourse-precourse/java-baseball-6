package baseball;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private final Map<CompareStatus, Integer> result = new HashMap<>();

    public int get(CompareStatus compareStatus) {
        return result.get(compareStatus);
    }

    public void set(CompareStatus compareStatus, int compareCount) {
        result.put(compareStatus, compareCount);
    }
}
