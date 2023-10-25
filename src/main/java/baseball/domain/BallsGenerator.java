package baseball.domain;

import java.util.List;

public interface BallsGenerator {

    Ball generateBall(int position);

    List<Ball> generateBalls();
}
