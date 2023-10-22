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
        for (int inning = 0; inning < MAX_BALL_SIZE; inning++) {
            int computerBall = computerBalls.get(inning);
            int playerBall = player.getPlayerBall(inning);
            calculateScore(computerBall, playerBall);
        }
        return formatResult();
    }

    private void initScoreBoard() {
        scoreBoard.put(STRIKE, SCORE_ZERO);
        scoreBoard.put(BALL, SCORE_ZERO);
    }

    private void calculateScore(final int computerBall, final int playerBall) {
        if (computerBall == playerBall) {
            int score = scoreBoard.get(STRIKE);
            scoreBoard.put(STRIKE, ++score);
            return;
        }
        if (computerBalls.contains(playerBall)) {
            int score = scoreBoard.get(BALL);
            scoreBoard.put(BALL, ++score);
        }
    }

    private String formatResult() {
        int strikeScore = scoreBoard.get(STRIKE);
        int ballScore = scoreBoard.get(BALL);
        if (isNothing(strikeScore, ballScore)) {
            return NOTHING.getDescription();
        }
        return formatString(strikeScore, ballScore);
    }

    private boolean isNothing(final int strikeScore, final int ballScore) {
        return (strikeScore == SCORE_ZERO) && (ballScore == SCORE_ZERO);
    }

    private String formatString(final int strikeScore, final int ballScore) {
        StringBuilder sb = new StringBuilder();
        if (ballScore > SCORE_ZERO) {
            sb.append(ballScore).append(BALL.getDescription());
        }
        sb.append(" ");
        if (strikeScore > SCORE_ZERO) {
            sb.append(strikeScore).append(STRIKE.getDescription());
        }
        return sb.toString().trim();
    }

    public boolean isGameEnd() {
        return scoreBoard.get(STRIKE) == MAX_BALL_SIZE;
    }
}
