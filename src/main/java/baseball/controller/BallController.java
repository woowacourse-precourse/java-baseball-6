package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.hint.Ball;
import baseball.service.hint.BallService;

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

    public static String getCountIfOverValue(Ball ball, int value) {
        String count = getEmptyIfIntNotOverValue(ball.getCount(), value);
        return count;
    }

    public static String getEmptyIfIntNotOverValue(int i, int value){
        if (i <= value) {
            return "";
        }
        return String.valueOf(i);
    }
}
