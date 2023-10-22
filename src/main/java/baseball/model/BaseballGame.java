package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    public static final int MIN_BALL = 1;
    public static final int MAX_BALL = 9;
    public static final int MAX_BALL_SIZE = 3;
    private final List<Integer> computerBalls = new ArrayList<>();


    public BaseballGame() {
        initComputerBalls();
    }

    private void initComputerBalls() {
        while (computerBalls.size() < MAX_BALL_SIZE) {
            int ball = Randoms.pickNumberInRange(MIN_BALL, MAX_BALL);
            if (!computerBalls.contains(ball)) {
                computerBalls.add(ball);
            }
        }
    }
}
