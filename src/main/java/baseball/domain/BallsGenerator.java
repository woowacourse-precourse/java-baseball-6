package baseball.domain;

import java.util.List;

public interface BallsGenerator {

    Ball generateBall(int position, NumberGenerator numberGenerator);

    List<Ball> generateBalls(NumberGenerator numberGenerator);
}
