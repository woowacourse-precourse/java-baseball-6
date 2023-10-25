package baseball.model;

import baseball.model.ball.Balls;
import baseball.validate.NumbersValidate;
import java.util.List;

public class BaseBallGamePlayer {

    Balls balls;

    public Balls generateBalls(List<Integer> givenNumbers) {
        NumbersValidate.gameGuessNumbersCheck(givenNumbers);
        this.balls = new Balls(givenNumbers);
        return balls;
    }

    public Hint guessBalls(Balls targetBalls) {
        return balls.match(targetBalls);
    }
}
