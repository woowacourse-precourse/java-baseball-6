package baseball.dto;

import baseball.domain.BallStatus;
import java.util.EnumMap;
import java.util.Objects;

public class GuessResult {

    private static final int DEFAULT_BALL_COUNT = 0;
    private static final int INITIAL_BALL_COUNT = 1;
    private static final int MAXIMUM_BALL_COUNT = 3;

    private final EnumMap<BallStatus, Integer> statuses;

    private GuessResult() {
        this.statuses = new EnumMap<>(BallStatus.class);
    }

    public static GuessResult empty() {
        return new GuessResult();
    }

    public boolean correct() {
        return count(BallStatus.STRIKE) == MAXIMUM_BALL_COUNT;
    }

    public void add(BallStatus ballStatus) {
        statuses.merge(ballStatus, INITIAL_BALL_COUNT, Integer::sum);
    }

    public int count(BallStatus ballStatus) {
        return statuses.getOrDefault(ballStatus, DEFAULT_BALL_COUNT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GuessResult that = (GuessResult) o;
        return Objects.equals(statuses, that.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statuses);
    }

    @Override
    public String toString() {
        return "GuessResult{" +
                "statuses=" + statuses +
                '}';
    }
}
