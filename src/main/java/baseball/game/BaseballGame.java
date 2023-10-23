package baseball.game;

import baseball.domain.BallHint;
import baseball.domain.BallInput;
import baseball.domain.RandomNumber;
import java.util.List;

public class BaseballGame {
    private final RandomNumber randomNumber;
    private final BallHint ballHint;
    private final BallInput ballInput;

    public BaseballGame() {
        this.randomNumber = new RandomNumber();
        this.ballHint = new BallHint();
        this.ballInput = new BallInput();
    }

    public void saveInput(String input) {
        ballInput.saveInput(input);
    }

    public void compareNumber() {
        ballHint.resetHint();
        List<Integer> computer = randomNumber.getNumbers();
        List<Integer> user = ballInput.getBalls();
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                ballHint.increaseStrike();
                user.set(i, 0);
            }
        }
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i))) {
                ballHint.IncreaseBall();
            }
        }
    }

    public RandomNumber getRandomNumber() {
        return this.randomNumber;
    }


    public BallInput getBallInput() {
        return this.ballInput;
    }

    public void resetGame() {
        randomNumber.randomNumberGenerator();
        ballHint.resetHint();
        ballInput.resetBalls();
    }
}
