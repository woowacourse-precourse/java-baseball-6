package baseball.collaborator.generic;

public record BallCount(long countOfStrike, long countOfBall) {

    public static final long NO_COUNT = 0L;
    public static final long MAX_COUNT = 3L;

    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";

    // compact constructor
    public BallCount {
        validation(countOfStrike, countOfBall);
    }

    private static void validation(long countOfStrike, long countOfBall) {
        if (countOfStrike < 0 ||
                countOfBall < 0 ||
                MAX_COUNT < countOfStrike + countOfBall) {
            throw new IllegalArgumentException("잘못된 볼카운팅입니다.");
        }
    }

    public boolean isFullCount() {
        return countOfStrike == MAX_COUNT;
    }

    @Override
    public String toString() {
        if (countOfBall != NO_COUNT && countOfStrike != NO_COUNT) {
            return countOfBall + BALL + " " + countOfStrike + STRIKE;
        }
        if (countOfBall != NO_COUNT) {
            return countOfBall + BALL;
        }
        if (countOfStrike != NO_COUNT) {
            return countOfStrike + STRIKE;
        }
        return NOTHING;
    }

}
