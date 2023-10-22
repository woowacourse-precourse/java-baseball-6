package baseball;

final class Computer {

    private Digits digits = Digits.generateRandomDigits();

    Result calculateScore(final Digits target){
        int strikeCount = digits.countStrike(target);
        int ballCount = digits.countBall(target);
        return new Result(ballCount, strikeCount);
    }

    void prepareGameRetry() {
        digits = Digits.generateRandomDigits();
    }
}
