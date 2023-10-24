package baseball.baseballV1.model;

public class Game {
    public GameResult compareBalls(Ball playerBall, Ball computerBall) {
        return playerBall.compare(computerBall);
    }

    public String checkTripleBalls(TripleBalls computerTripleBalls, TripleBalls userTripleBalls) {
        return computerTripleBalls.compareTripleBalls(userTripleBalls);
    }
}
