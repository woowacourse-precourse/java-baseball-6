package baseball.domain.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Score {
    private final Map<BallCount, Integer> score;

    public Score() {
        this.score = intiScoreMap();
    }

    public Score(final Map<BallCount, Integer> score) {
        this.score = score;
    }

    public Score(final Computer computer, final User user) {
        this.score = user.compareWithComputerBalls(computer, intiScoreMap());
    }

    private Map<BallCount, Integer> intiScoreMap() {
        return Arrays.stream(BallCount.values())
                .collect(Collectors.toMap(value -> value, count -> 0, (a, b) -> b,
                        () -> new EnumMap<>(BallCount.class)));
    }
}
