package baseball.domain;

import java.util.List;

public interface Balls {

    int VALID_BALL_COUNT = 3;

    List<Ball> balls();

    Ball ballAt(int index);

}
