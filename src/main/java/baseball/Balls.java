package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Integer> list) {
        if (list.size() != 3) {
            throw new IllegalArgumentException();
        }

        this.balls = makeBallList(list);
    }

    private List<Ball> makeBallList(List<Integer> list) {
        List<Ball> ballList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ballList.add(new Ball(list.get(i), (i + 1)));
        }
        return ballList;
    }

    public BallResultEnum play(Ball ball) {

        return balls.stream()
                .map(comBall -> ball.play(comBall))
                .filter(ballResultEnum -> ballResultEnum != BallResultEnum.NOTHING)
                .findFirst()
                .orElse(BallResultEnum.NOTHING);
    }

    public PlayResult play(Balls userBalls) {

        PlayResult playResult = new PlayResult();

        balls.stream()
                .map(userBalls::play)
                .forEach(playResult::result);

        return playResult;
    }
}
