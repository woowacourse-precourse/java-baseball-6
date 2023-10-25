package baseball.domain;

import java.util.List;
import java.util.Objects;

class Player {
    private static final Integer REGAME_NUMBER = 1;
    private final Reader reader;

    Player() {
        this.reader = new Reader();
    }

    Ball pickBalls() {
        List<Integer> balls = reader.readThreeNumbers();
        return new Ball(balls);
    }

    boolean isReGame() {
        return Objects.equals(reader.readOneNumber(), REGAME_NUMBER);
    }
}
