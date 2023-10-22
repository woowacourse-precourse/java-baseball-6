package baseball;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private static final int PLUS_COUNT = 1;
    private final Map<CompareStatus, Integer> result = new EnumMap<>(CompareStatus.class);

    public int get(CompareStatus compareStatus) {
        return result.getOrDefault(compareStatus, 0);
    }

    public boolean isNothing() {
        return result.size() == 0;
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

    public void putCount(CompareStatus compareStatus, int statusCount) {
        if (compareStatus != CompareStatus.NOTHING) {
            result.put(compareStatus, statusCount + PLUS_COUNT);
        }
    }
}
