package baseball.domain.util;

import baseball.domain.ball.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBallGenerator {
    public static final int ZERO = 0;
    public static final int SIZE_OF_NUMBER = 3;
    private static final int SMALLEST_NUMBER = 1;
    private static final int LARGEST_NUMBER = 9;

    public static List<Ball> makeBalls() {
        List<Ball> balls = new ArrayList<>();
        List<Integer> numbersToCheckDuplicate = new ArrayList<>();
        for (int i = ZERO; i < SIZE_OF_NUMBER; i++) {
            int randomNumber = getRandomNumberWithoutDuplicate(numbersToCheckDuplicate);
            balls.add(new Ball(randomNumber, i));
        }
        return balls;
    }

    private static int getRandomNumberWithoutDuplicate(List<Integer> numbers) {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(SMALLEST_NUMBER, LARGEST_NUMBER);
        } while (numbers.contains(randomNumber));
        numbers.add(randomNumber);
        return randomNumber;
    }
}