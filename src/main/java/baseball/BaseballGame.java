package baseball;

public class BaseballGame {
    private final String targetNumber;

    public BaseballGame() {
        this.targetNumber = BallGenerator.generateUniqueBaseballNumber();
    }

    public void play() {
        int strikes = -1;
        int balls = -1;
        while (strikes != 3) {
            String userInput = Input.getUserInput();
            strikes = Referee.calculateStrike(userInput, targetNumber);
            balls = Referee.calculateBall(userInput, targetNumber);
            if (strikes > 0 && balls > 0) {
                Output.printBallAndStrike(balls, strikes);
            } else if (strikes > 0) {
                Output.printOnlyStrike(strikes);
            } else if (balls > 0) {
                Output.printOnlyBall(balls);
            } else if (strikes == 0 && balls == 0) {
                Output.printNothing();
            }
        }
        Output.printFinishGame();
    }
}
