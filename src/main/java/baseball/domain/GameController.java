package baseball.domain;

public class GameController {
    private BallNumber computerNumber;

    public Score computeUserScore(int number) {
        BallNumber userNumber = new BallNumber(number);
        return ScoreCalculator.createScore(userNumber, computerNumber);
    }

    public void initComputerNumber() {
        computerNumber = new BallNumber(
                RandomNumberGenerator.makeComputerNumber());
    }

    public void makeComputerNumber() {
        computerNumber = new BallNumber(RandomNumberGenerator.makeComputerNumber());
    }
}
