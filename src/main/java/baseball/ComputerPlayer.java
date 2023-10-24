package baseball;

public class ComputerPlayer {

    private BaseBallNumber goalNumber;

    public ComputerPlayer(GameRule rule) {
        goalNumber = new BaseBallNumber(rule);
    }

    public void decideGoalNumber() {
        this.goalNumber.initGoalNumber();
    }

    public ResultOfGuess evaluateGuess(BaseBallNumber guess) {
        return goalNumber.countBallAndStrike(guess);
    }
}
