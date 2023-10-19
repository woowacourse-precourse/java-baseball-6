package baseball.model;

import baseball.model.Ball;
import baseball.model.GameResult;
import baseball.model.TripleBalls;

public class Game {
    public GameResult compareBalls(Ball playerBall, Ball computerBall) {
        return playerBall.compare(computerBall);
    }

    public String checkTripleBalls(TripleBalls computerTripleBalls, TripleBalls userTripleBalls) {
        // TripleBalls 구성하는 3개의 Ball을 각각 비교해야 한다
        // computerTripBalls 구성하는 Ball 순서대로 userTipleBalls를 하나하나 비교해야 한다
        return computerTripleBalls.compareTripleBalls(userTripleBalls);
    }
}
