package baseball.model;

import baseball.util.SplitLine;
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
    private static Map<Integer, Integer> computerBallInfo;
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

    public Map<String, Integer> judgeBaseBallGame(String numbers) {
        Map<String, Integer> gameResult = compareBalls(numbers);
        return gameResult;
    }

    private Map<String, Integer> compareBalls(String numbers) {
        Map<String, Integer> compareResult = new HashMap<>();
        BallNumberGroup playerBallNumberGroup = generateBallGroup(numbers);
        List<BallNumber> playerBalls = playerBallNumberGroup.getBallNumberGroup();

        for (int bIdx = 0; bIdx < BALL_NUMBER_SIZE; bIdx++) {
            Integer playerBall = playerBalls.get(bIdx).getNumber();
            if (!computerBallInfo.containsKey(playerBall)) {
                compareResult.put(NOTHING, compareResult.getOrDefault(NOTHING, 0) + 1);
            } else {
                if (bIdx == computerBallInfo.get(playerBall)) {
                    compareResult.put(STRIKE, compareResult.getOrDefault(STRIKE, 0) + 1);
                } else if (bIdx != computerBallInfo.get(playerBall)) {
                    compareResult.put(BALL, compareResult.getOrDefault(BALL, 0) + 1);
                }
            }
        }
        return compareResult;
    }

    private BallNumberGroup generateBallGroup(String numbers) {
        List<Integer> playerBalls = SplitLine.splitLine(numbers);
        BallNumberGroup ballNumberGroup = new BallNumberGroup(playerBalls);
        return ballNumberGroup;
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
