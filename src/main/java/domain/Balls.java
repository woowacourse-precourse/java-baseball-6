package domain;

import java.util.List;
import util.validator.BallDuplicateValidator;
import util.validator.BallSizeValidator;

public class Balls {

    private final List<Ball> balls;


    public Balls(List<Ball> balls) {
        BallDuplicateValidator ballDuplicateValidator = BallDuplicateValidator.getInstance();
        BallSizeValidator ballSizeValidator = BallSizeValidator.getInstance();
        ballDuplicateValidator.validate(balls);
        ballSizeValidator.validate(balls);
        this.balls = balls;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
