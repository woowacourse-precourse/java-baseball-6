package baseball;

final class Computer {

    private Digits digits = Digits.generateRandomDigits();

    Result calculateScore(Digits target){
        int strikeCount = digits.countStrike(target);
        int ballCount = digits.countBall(target) - strikeCount;
        return new Result(ballCount, strikeCount);
    }

    void prepareGameRetry() {
        digits = Digits.generateRandomDigits();
    }
}
