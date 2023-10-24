package baseball;

import java.util.HashMap;

public class CompareResult {
    private final HashMap<String, Integer> compareResult = new HashMap<>();

    public CompareResult(int strikeCount, int ballCount) {
        compareResult.put("strikeCount", strikeCount);
        compareResult.put("ballCount", ballCount);
    }

    public void printCompareResult() {
        int strikeCount = getStrikeCount();
        int ballCount = getBallCount();

        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        }
        if (ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
    }

    public int getStrikeCount() {
        return compareResult.get("strikeCount");
    }

    public int getBallCount() {
        return compareResult.get("ballCount");
    }
}
