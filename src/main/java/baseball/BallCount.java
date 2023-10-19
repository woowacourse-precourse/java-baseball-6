package baseball;

public record BallCount(long strike, long ball) {

    public static final long MAX_OF_STRIKE = 3L;

    public boolean isFullCount() {
        return strike == MAX_OF_STRIKE;
    }

}
