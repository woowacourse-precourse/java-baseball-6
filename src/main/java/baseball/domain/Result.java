package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<BallStatus, Integer> map;


    public Result(List<BallStatus> ballStatuses) {
        this.map = toMap(ballStatuses);

    }

    public Map<BallStatus, Integer> toMap(List<BallStatus> ballStatuses) {
        Map<BallStatus, Integer> map = new HashMap<>();
        for (BallStatus ballStatus : BallStatus.values()) {
            int count = (int) ballStatuses.stream()
//                    .filter(result -> !result.equals(BallStatus.NOTHING))
                    .filter(result -> result.equals(ballStatus))
                    .count();
            if (count != 0) {
                map.put(ballStatus, count);
            }
        }
        return map;
    }

    public Map<BallStatus, Integer> getMap() {
        return map;
    }
}
