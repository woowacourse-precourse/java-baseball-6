package baseball.domain;

import static baseball.util.Constants.BALL_AMOUNT;

import baseball.util.ComputerRandomNumberGenerator;
import baseball.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class ComputerBalls {

    List<Ball> balls;
    private RandomNumberGenerator randomNumberGenerator;


    public ComputerBalls() {
        this.randomNumberGenerator = new ComputerRandomNumberGenerator();
        balls = new ArrayList<>();
    }

    public void setRandomBalls() {
        List<Integer> uniqueNumbers = randomNumberGenerator.createUniqueNumbers(BALL_AMOUNT);
        for (int position = 0; position < BALL_AMOUNT; position++) {
            balls.add(new Ball(position, uniqueNumbers.get(position)));
        }
    }
}
