package baseball.domain.util;

import baseball.domain.ball.Ball;
import java.util.ArrayList;
import java.util.List;

import static baseball.domain.util.RandomBallGenerator.SIZE_OF_NUMBER;
import static baseball.domain.util.RandomBallGenerator.ZERO;

public class BallsConvertor {
    private static final int HUNDRED = 100;
    private static final int TEN = 10;
    private static final int ONE = 1;

    public static List<Ball> convertNumberToBalls(int number) {
        List<Ball> balls = new ArrayList<>();
        List<Integer> cutNumbers = cutNumber(number);
        for (int i = ZERO; i < SIZE_OF_NUMBER; i++) {
            balls.add(new Ball(cutNumbers.get(i), i));
        }
        return balls;
    }

    static List<Integer> cutNumber(int number) {
        List<Integer> cutNumbers = new ArrayList<>();
        for (int i = HUNDRED; i >= ONE; i /= TEN) {
            cutNumbers.add(number / i);
            number %= i;
        }
        return cutNumbers;
    }
}