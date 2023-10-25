package baseball.domain;

import java.util.List;

class Player {
    private final Reader reader;

    Player() {
        this.reader = new Reader();
    }

    Ball pickBalls() {
        List<Integer> balls = reader.readThreeNumbers();
        return new Ball(balls);
    }
}
