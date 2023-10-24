package baseball.service;

import baseball.domain.Ball;
import baseball.domain.GameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import baseball.constant.Constant;

public class GameService {

    public static GameResult judge(final List<Ball> playerBalls, final List<Ball> computerBalls) {
        Integer strike = countStrike(playerBalls, computerBalls);
        Integer ball = countBall(playerBalls, computerBalls);
        return new GameResult(strike, ball);
    }

    private static Integer countStrike(final List<Ball> playerBalls, final List<Ball> computerBalls) {
        return countSameBallAndPosition(playerBalls, computerBalls);
    }

    private static Integer countBall(final List<Ball> playerBalls, final List<Ball> computerBalls) {
        return countSameBall(playerBalls, computerBalls) - countSameBallAndPosition(playerBalls, computerBalls);
    }

    // count number of same numbers between playerBalls and computerBalls.
    private static Integer countSameBall(final List<Ball> playerBalls, final List<Ball> computerBalls) {
        List<Ball> totalBallsList = Stream.of(playerBalls, computerBalls)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        Set<Ball> totalBallsSet = totalBallsList.stream()
                .collect(Collectors.toSet());

        return totalBallsList.size() - totalBallsSet.size();
    }

    private static Integer countSameBallAndPosition(final List<Ball> playerBalls, final List<Ball> computerBalls) {
        Integer count = 0;
        for (int i=0; i<Constant.BALLS_LENGTH; i++) {
            count += playerBalls.get(i).equals(computerBalls.get(i)) ? 1 : 0;
        }

        return count;
    }


}
