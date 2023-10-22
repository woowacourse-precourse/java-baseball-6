package baseball.domain;

public class ComputerPlayer implements MatchPlayer {

    private final BaseBallNumbers answer;

    public ComputerPlayer(BaseBallNumberGenerator numberGenerator) {
        this.answer = numberGenerator.create();
    }

    @Override
    public void getHintOf(BaseBallNumbers baseBallNumber) {
        int ballCount = countBall(baseBallNumber);
    }

    private int countBall(BaseBallNumbers baseBallNumbers) {
        int ballCount = 0;
        for (int number : baseBallNumbers.get()) {
            if(answer.isContain(number)) ballCount++;
        }
        return ballCount;
    }


}
