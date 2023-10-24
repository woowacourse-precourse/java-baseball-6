package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseBallManager {
    private static final int BALL_NUMBER_SIZE = 3;
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static BallNumberGroup computerBallGroup;
    private static Map<Integer, Integer> computerBallInfo;  // BallNumber, idx
    private static Map<String, Integer> playerResult;

    public BaseBallManager() {
        this.computerBallGroup = new BallNumberGroup(generateUniqueRandomNumbers());
        computerBallInfo = new HashMap<>();
        List<BallNumber> computerBall = computerBallGroup.getBallNumberGroup();
        for (int ballIdx = 0; ballIdx < BALL_NUMBER_SIZE; ballIdx++) {
            computerBallInfo.put(computerBall.get(ballIdx).getNumber(), ballIdx);
        }
    }

    public Map<String, Integer> compareBaseBall(BallNumberGroup playerBallGroup) {
        playerResult = new HashMap<>();
        List<BallNumber> playerBalls = playerBallGroup.getBallNumberGroup();
        int nothingCount = 0;

        for (int ballIdx = 0; ballIdx < BALL_NUMBER_SIZE; ballIdx++) {
            Integer playerBall = playerBalls.get(ballIdx).getNumber();
            if (!computerBallInfo.containsKey(playerBall)) {
                nothingCount++;
            } else {
                if (ballIdx == computerBallInfo.get(playerBall)) {
                    playerResult.put(STRIKE, playerResult.getOrDefault(STRIKE, 0) + 1);
                } else if (ballIdx != computerBallInfo.get(playerBall)) {
                    playerResult.put(BALL, playerResult.getOrDefault(BALL, 0) + 1);
                }
            }
        }

        if (nothingCount == 3) playerResult.put(NOTHING, 1);

        return playerResult;
    }

    private List<Integer> generateUniqueRandomNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < BALL_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
