package baseball;

import java.util.HashMap;

public class CompareResult {
    private final HashMap<String, Integer> compareResult = new HashMap<>();

    public CompareResult(int strikeCount, int ballCount) {
        compareResult.put("strikeCount", strikeCount);
        compareResult.put("ballCount", ballCount);
    }

    public int getStrikeCount() {
        return compareResult.get("strikeCount");
    }

    public int getBallCount() {
        return compareResult.get("ballCount");
    }
}
