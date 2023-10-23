package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class SelectedBalls {
    private static final int SIZE_OF_BALL = 3;
    private static final int MIN_VALUE_OF_BALL = 1;
    private static final int MAX_VALUE_OF_BALL = 9;

    private final Queue<Integer> balls = new LinkedList<>();

    private SelectedBalls() {
        initBalls();
    }

    public static SelectedBalls getNewSelectedBalls() {
        return new SelectedBalls();
    }

    private void initBalls() {
        while (balls.size() < SIZE_OF_BALL) {
            int ball = Randoms.pickNumberInRange(MIN_VALUE_OF_BALL, MAX_VALUE_OF_BALL);
            if (balls.contains(ball)) {
                continue;
            }
            balls.add(ball);
        }
    }

    public String getStringOfBalls() {
        return balls.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
