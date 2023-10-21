package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Baseball {

    public static int MIN_POSITION = 1;
    public static int MAX_POSITION = 9;

    private final int order;
    private final int position;

    private Baseball(int order, int position) {
        this.order = order;
        this.position = position;
    }

    public static Baseball of(int order, int position) {
        return new Baseball(order, position);
    }

    public static Map<Integer, Baseball> partitionBallsByOrder(List<Baseball> baseballs) {
        return partitionBalls(baseballs, (baseball) -> baseball.order);
    }

    public static Map<Integer, Baseball> partitionBallsByPosition(List<Baseball> baseballs) {
        return partitionBalls(baseballs, (baseball) -> baseball.position);
    }

    private static Map<Integer, Baseball> partitionBalls(List<Baseball> baseballs,
            Function<Baseball, Integer> keyMapper) {
        Map<Integer, Baseball> partitionedBalls = new HashMap<>();
        baseballs.forEach(baseball -> partitionedBalls.put(keyMapper.apply(baseball), baseball));

        return partitionedBalls;
    }
}
