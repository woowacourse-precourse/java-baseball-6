package domain;


import java.util.List;
import java.util.stream.IntStream;

public class BallComparator {

    private final static int BEGIN_INDEX = 0;
    private final static int END_INDEX = 2;

    private final static int MAX_STRIKE = 3;

    public GameResult compareStatus(Balls userBalls, Balls computerBalls) {
        int strike = countStrike(userBalls.getBalls(), computerBalls.getBalls());
        int ball = countBall(userBalls.getBalls(), computerBalls.getBalls(), strike);
        return new GameResult(strike, ball);
    }


    private int countStrike(List<Ball> userBalls, List<Ball> computerBalls) {
        int strike = (int) IntStream.rangeClosed(BEGIN_INDEX, END_INDEX)
                .filter(i -> userBalls.get(i).equals(computerBalls.get(i)))
                .count();

        return strike;
    }

    private int countBall(List<Ball> userBalls, List<Ball> computerBalls, int strike) {
        if (strike == MAX_STRIKE) {
            return 0;
        }
        int ball = (int) userBalls.stream()
                .filter(userBall -> computerBalls.stream()
                        .anyMatch(computerBall -> computerBall.getBallNumber()
                                .equals(userBall.getBallNumber())))
                .count();

        return ball - strike;
    }

}
