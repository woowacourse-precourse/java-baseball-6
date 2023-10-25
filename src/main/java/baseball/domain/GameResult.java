package baseball.domain;

import baseball.status.CompareStatus;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private static final int PLUS_COUNT = 1;
    private static final int THREE_STRIKE = 3;
    private static final int DEFAULT = 0;
    private final Map<CompareStatus, Integer> result = new EnumMap<>(CompareStatus.class);

    public int get(CompareStatus compareStatus) {
        return result.getOrDefault(compareStatus, DEFAULT);
    }

    public boolean isNothing() {
        return result.size() == 0;
    }

    public boolean isNotThreeStrike() {
        return result.getOrDefault(CompareStatus.STRIKE, DEFAULT) != THREE_STRIKE;
    }

    public List<String> getBallAndStrikeResult() {
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
