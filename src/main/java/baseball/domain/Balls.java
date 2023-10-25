package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> ballNums) {
        this.balls = saveBallsInfo(ballNums);
    }

    private List<Ball> saveBallsInfo(List<Integer> ballNums) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < ballNums.size(); i++) {
            balls.add(new Ball(i, ballNums.get(i)));
        }
        return balls;
    }

    public BallHint makeBallHint(Ball ball) {
        return balls.stream().map(b -> b.play(ball))
                .filter(hint -> hint != BallHint.NOTHING)
                .findFirst()
                .orElse(BallHint.NOTHING);
    }

    public Result play(List<Integer> userNums) {
        Balls userBalls = new Balls(userNums);
        Result result = new Result();

        for (Ball ball : balls) {
            BallHint hint = userBalls.makeBallHint(ball);
            result.report(hint);
        }
        return result;
    }
}