package domain;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BallComparator {

    private static int BEGIN_INDEX = 0;
    private static int END_INDEX = 2;

    private static int MAX_STRIKE = 3;

    public GameResult compareStatus(Balls userBalls, Balls computerBalls) {
        int strike = countStrike(userBalls.getBalls(), computerBalls.getBalls());
        int ball = countBall(userBalls.getBalls(), computerBalls.getBalls(), strike);
        return new GameResult(strike, ball);
    }

    private int countStrike(List<Ball> userBalls, List<Ball> computerBalls) {
        int strike = 0;
        for (int i = BEGIN_INDEX; i <= END_INDEX; i++) {
            BallNumber userBall = userBalls.get(i).getBallNumber();
            BallNumber computerBall = computerBalls.get(i).getBallNumber();
            if (userBall.getBallNumber() == computerBall.getBallNumber()) {
                strike += 1;
            }
        }

        return strike;
    }

    private int countBall(List<Ball> userBalls, List<Ball> computerBalls, int strike) {
        if (strike == MAX_STRIKE) {
            return 0;
        }
        Set<Integer> ballsSet = new HashSet<>();
        for (Ball userBall : userBalls) {
            BallNumber ballNumber = userBall.getBallNumber();
            ballsSet.add(ballNumber.getBallNumber());
        }
        int ball = (int) IntStream.rangeClosed(BEGIN_INDEX, END_INDEX)
                .mapToObj(computerBalls::get)
                .map(Ball::getBallNumber)
                .map(BallNumber::getBallNumber)
                .filter(ballsSet::contains)
                .count();

        return ball - strike;
    }

}
