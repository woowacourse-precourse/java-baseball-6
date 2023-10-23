package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Hint.Ball;
import baseball.service.BallService;

public class BallController {
    private static final BallService ballService = BallService.getInstance();

    public static Ball create(Baseball computerBaseball, Baseball inputBaseball) {
        Ball ball = new Ball();

        ball.setCount(ballService.count(computerBaseball, inputBaseball));
        ball.setActive(ballService.active(ball));
        return ball;
    }

    public static boolean isActive(Ball ball) {
        return ball.isActive();
    }

}
