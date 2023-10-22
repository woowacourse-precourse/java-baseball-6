package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Integer> list) {
        if (list.size() != 3) {
            throw new IllegalArgumentException();
        }

        List<Ball> ballList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ballList.add(new Ball(list.get(i), (i + 1)));
        }
        this.balls = ballList;
    }

    public String play(Ball ball) {

        for (int i = 0; i < balls.size(); i++) {
            if (ball.play(balls.get(i)) == "스트라이크") {
                return "스트라이크";
            }

            if (ball.play(balls.get(i)) == "볼") {
                return "볼";
            }
        }


        return "낫싱";
    }

    public PlayResult play(Balls userBalls) {

        PlayResult playResult = new PlayResult();
        balls.stream()
                .map(ball -> userBalls.play(ball))
                .forEach(result -> playResult.result(result));

        return playResult;
    }
}
