package baseball.domain;

public class ComputerPlayer implements MatchPlayer {

    private final BaseBallNumbers answer;

    public ComputerPlayer(BaseBallNumberGenerator numberGenerator) {
        this.answer = numberGenerator.create();
    }

    @Override
    public BaseBallHint getHintOf(BaseBallNumbers baseBallNumber) {
        final int ball = countBall(baseBallNumber);
        final int strike = countStrike(baseBallNumber);
        return new BaseBallHint(
                ball - strike,
                strike
        );
    }

    private int countBall(BaseBallNumbers baseBallNumbers) {
        int ballCount = 0;
        for (int number : baseBallNumbers.get()) {
            if(answer.isBall(number)) ballCount++;
        }
        return ballCount;
    }

    private int countStrike(BaseBallNumbers baseBallNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < baseBallNumbers.size() ; i++) {
            int number = baseBallNumbers.get().get(i);
            if (answer.isStrike(number, i)) strikeCount++;
        }
        return strikeCount;
    }
}
