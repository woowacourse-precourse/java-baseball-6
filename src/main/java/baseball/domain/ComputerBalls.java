package baseball.domain;

import static baseball.util.Constants.BALL_AMOUNT;

import baseball.util.ComputerRandomNumberGenerator;
import baseball.util.RandomNumberGenerator;
import java.util.List;

public class ComputerBalls {

    private Balls balls;
    private RandomNumberGenerator randomNumberGenerator;

    public ComputerBalls() {
        this.randomNumberGenerator = new ComputerRandomNumberGenerator();
        balls = new Balls(setRandomBalls());
    }

    private List<Integer> setRandomBalls() {
        return randomNumberGenerator.createUniqueNumbers(BALL_AMOUNT);
    }

    public Balls getBalls() {
        return balls;
    }
}
