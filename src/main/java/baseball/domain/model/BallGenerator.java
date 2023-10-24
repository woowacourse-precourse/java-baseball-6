package baseball.domain.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallGenerator {
    private static final int COMPUTER_MAX_SIZE = 3;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    private BallGenerator() {
    }

    private static class BallHolder {
        private static final BallGenerator INSTANCE = new BallGenerator();
    }

    public static BallGenerator getInstance() {
        return BallHolder.INSTANCE;
    }

    public String createRandomBall() {
        return String.valueOf(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
    }

    public List<String> makeComputerBalls() {
        List<String> balls = new ArrayList<>();
        while (balls.size() < COMPUTER_MAX_SIZE) {
            checkBallDuplication(balls);
        }
        return balls;
    }

    private void checkBallDuplication(List<String> balls) {
        String randomBall = createRandomBall();
        if (!balls.contains(randomBall)) {
            balls.add(randomBall);
        }
    }
}
