package baseball.domain;

record BaseBallResult(int ballCount, int strikeCount) {
    boolean isPerfectStrike() {
        return BaseBall.DIGITS == strikeCount;
    }
}