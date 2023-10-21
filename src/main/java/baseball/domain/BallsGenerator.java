package baseball.domain;

import java.util.List;

public interface BallsGenerator {

    List<Ball> generate(NumberGenerator numberGenerator);

    List<Ball> generate(Ball... balls);
}
