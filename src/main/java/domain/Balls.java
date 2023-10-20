package domain;

import java.util.List;
import util.validator.BallDuplicateValidator;

public class Balls {

    private final List<Ball> balls;


    public Balls(List<Ball> balls) {
        BallDuplicateValidator ballDuplicateValidator = BallDuplicateValidator.getInstance();
        ballDuplicateValidator.validate(balls);
        this.balls = balls;
    }
}
