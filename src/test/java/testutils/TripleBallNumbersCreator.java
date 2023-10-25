package testutils;

import baseball.domain.ball.BallNumber;
import collection.Triple;

public final class TripleBallNumbersCreator {
    public static Triple<BallNumber> createTripleBallNumbers(
            final int first,
            final int second,
            final int third
    ) {
        return Triple.of(
                new BallNumber(first),
                new BallNumber(second),
                new BallNumber(third)
        );
    }
}
