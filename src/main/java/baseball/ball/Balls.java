package baseball.ball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> balls =new ArrayList<>();
    public Balls(List<Integer> givenNumbers) {
        int position = 1;
        for(Integer number:givenNumbers){
            this.balls.add(new Ball(position++,number));
        }
    }

    public BallStatus match(Ball targetBall) {
        return this.balls.stream()
                .map(ball -> ball.match(targetBall))
                .filter(ballStatus -> ballStatus != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
