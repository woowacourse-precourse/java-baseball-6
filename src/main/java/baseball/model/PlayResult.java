package baseball.model;

public record PlayResult(
        long numberOfStrike,
        long numberOfBalls,
        boolean isNothing,
        boolean isClear
) {

    public static PlayResult from(final CompareResults compareResults) {
        return new PlayResult(
                compareResults.getStrikes(),
                compareResults.getBalls(),
                compareResults.isNothing(),
                compareResults.isAllStrike()
        );
    }

    public boolean hasStrike() {
        return numberOfStrike > 0;
    }

    public boolean hasBall() {
        return numberOfBalls > 0;
    }
}
