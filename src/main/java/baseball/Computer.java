package baseball;

final class Computer {

    final Digits digits = new Digits();

    Result calculateScore(Digits target){
        int strikeCount = digits.countStrike(target);
        int ballCount = digits.countBall(target) - strikeCount;
        return new Result(ballCount, strikeCount);
    }
}
