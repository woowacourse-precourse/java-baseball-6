package baseball.collaborator.generic;

import baseball.collaborator.generic.enums.BallCountMessage;

public record BallCount(long countOfStrike, long countOfBall) {

    public static final long NO_COUNT = 0L;
    public static final long MAX_COUNT = 3L;

    // compact constructor
    public BallCount {
        validation(countOfStrike, countOfBall);
    }

    private static void validation(long countOfStrike, long countOfBall) {
        if (countOfStrike < 0 ||
                countOfBall < 0 ||
                isTooManyCounts(countOfStrike, countOfBall)) {
            throw new IllegalArgumentException(BallCountMessage.INCORRECT_BALLCOUNTING.get());
        }
    }

    private static boolean isTooManyCounts(long countOfStrike, long countOfBall) {
        return MAX_COUNT < countOfStrike + countOfBall;
    }

    public boolean isFullCount() {
        return countOfStrike == MAX_COUNT;
    }

    @Override
    public String toString() {
        if (countOfBall != NO_COUNT && countOfStrike != NO_COUNT) {
            return countOfBall + BallCountMessage.BALL.get() +
                    " " + countOfStrike + BallCountMessage.STRIKE.get();
        }
        if (countOfBall != NO_COUNT) {
            return countOfBall + BallCountMessage.BALL.get();
        }
        if (countOfStrike != NO_COUNT) {
            return countOfStrike + BallCountMessage.STRIKE.get();
        }
        return BallCountMessage.NOTHING.get();
    }

}
