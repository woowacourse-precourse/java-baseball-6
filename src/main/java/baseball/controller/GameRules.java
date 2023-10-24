package baseball.controller;

import baseball.model.Ball;
import baseball.model.Score;
import java.util.List;
import java.util.stream.IntStream;

public class GameRules {

    public static Score getScore(List<Ball> computerBalls, List<Ball> userBalls) {
        int ball = countBall(computerBalls, userBalls);
        int strike = countStrike(computerBalls, userBalls);
        return new Score(ball, strike);
    }

    private static int countStrike(List<Ball> computerBalls, List<Ball> userBalls) {
        return (int) IntStream.range(0, computerBalls.size())
                .filter(index -> isDigitStrike(computerBalls.get(index), userBalls.get(index)))
                .count();
    }

    private static boolean isDigitStrike(Ball computerBall, Ball userBall) {
        return Ball.equals(computerBall, userBall);
    }

    private static int countBall(List<Ball> computerBalls, List<Ball> userBalls) {
        return (int) computerBalls.stream()
                .flatMap(computerBall -> userBalls.stream().filter(userBall ->
                        Ball.equals(computerBall, userBall) && computerBalls.indexOf(computerBall) != userBalls.indexOf(
                                userBall)
                ))
                .count();
    }
}
