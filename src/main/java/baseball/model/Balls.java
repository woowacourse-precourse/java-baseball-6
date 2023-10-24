package baseball.model;

import baseball.utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public static Balls createRandomBalls(int gameSize, int startDigit, int endDigit) {
        List<Ball> balls = new ArrayList<>();
        List<Integer> randomNumbers = RandomUtils.getRandomNumbers(gameSize, startDigit, endDigit);
        numbersToBalls(randomNumbers,balls);
        return new Balls(balls);
    }

    public static Balls createBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        numbersToBalls(numbers,balls);
        return new Balls(balls);
    }

    private static void numbersToBalls(List<Integer> numbers, List<Ball> balls) {
        for (int i = 0; i < numbers.size(); i++) {
            balls.add(new Ball(i, numbers.get(i)));
        }
    }

    public BallStatus compareBall(Ball ball) {
        return balls.stream()
                .map(refBall ->refBall.compareBall(ball))
                .filter(ballStatus -> ballStatus != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public GameResult compareBalls(Balls balls) {
        GameResult gameResult = new GameResult();
        balls.getBalls()
                .forEach(ball -> gameResult.updateResult(this.compareBall(ball)));
        return gameResult;
    }


}
