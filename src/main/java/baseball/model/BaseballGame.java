package baseball.model;

import static baseball.model.BallType.BALL;
import static baseball.model.BallType.NOTHING;
import static baseball.model.BallType.STRIKE;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    public static final int MIN_BALL = 1;
    public static final int MAX_BALL = 9;
    public static final int MAX_BALL_SIZE = 3;
    public static final int SCORE_ZERO = 0;
    private final List<Integer> computerBalls = new ArrayList<>();
    private final Map<BallType, Integer> scoreBoard = new EnumMap<>(BallType.class);

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

    public String getResult(final Player player) {
        initScoreBoard();
    }

    private void initScoreBoard() {
        scoreBoard.put(STRIKE, SCORE_ZERO);
        scoreBoard.put(BALL, SCORE_ZERO);
    }
}
