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
        if (compareStatus != CompareStatus.NOTHING) {
            result.put(compareStatus, compareCount);
        }
    }

    public boolean isNotThreeStrike() {
        return result.getOrDefault(CompareStatus.STRIKE, 0) != 3;
    }

    public List<String> getBallAndStrikeResult() {
        result.remove(null);
        return result.entrySet().stream()
                .filter(status -> status.getValue() != null)
                .map(status -> status.getValue() + status.getKey().toString())
                .toList();
    }
}
