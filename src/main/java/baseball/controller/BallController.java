package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Hint.Ball;
import baseball.service.BallService;

public class BallController {
    private static final BallService ballService = BallService.getInstance();

    public static Ball countBall(Baseball computerBaseball, Baseball inputBaseball) {
        Ball ball = new Ball();

        ball.setCount(ballService.count(computerBaseball, inputBaseball));

        return ball;
    }
}
