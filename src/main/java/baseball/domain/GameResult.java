package baseball.domain;

import baseball.constant.BallStatus;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class GameResult {

    private static final int DEFAULT = 0;
    private final Map<BallStatus, Integer> elements;

    public GameResult() {
        this.elements = new EnumMap<>(BallStatus.class);
        Arrays.stream(BallStatus.values())
                .forEach(value -> elements.put(value , DEFAULT));

    }

    public void increaseCount(BallStatus ballStatus) {
        elements.put(ballStatus, elements.get(ballStatus) + 1);
    }
}
