package baseball.baseballV2.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TripleBalls {
    public static final int STARTING_COUNT = 0;
    public final List<Ball> tripleBalls;

    public TripleBalls(List<Ball> tripleBalls) {
        this.tripleBalls = tripleBalls;
    }

    public List<Integer> compareTripleBallCondition(TripleBalls otherTripleBalls) {
        int ballCount = getBallCount(otherTripleBalls);
        int strikeCount = getStrikeCount(otherTripleBalls);

        return Arrays.asList(ballCount, strikeCount);
    }

    private int getBallCount(TripleBalls otherTripleBalls) {
        return getResultCount(otherTripleBalls, Result.BALL);
    }

    private int getStrikeCount(TripleBalls otherTripleBalls) {
        return getResultCount(otherTripleBalls, Result.STRIKE);

    }

    private int getResultCount(TripleBalls otherTripleBalls, Result result) {
        int count = STARTING_COUNT;
        for (Ball eachBall : tripleBalls) {
            count += otherTripleBalls.getTripleBalls()
                    .stream()
                    .filter(otherBall -> otherBall.compareBallCondition(eachBall) == result)
                    .count();
        }
        return count;
    }

    public List<Ball> getTripleBalls() {
        return Collections.unmodifiableList(tripleBalls);
    }
}
