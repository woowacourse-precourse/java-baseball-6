package baseball.model;

import baseball.GameMessage;
import baseball.util.SplitLine;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseBallManager {
    private static Map<Integer, Integer> computerBallInfo;
    private static BallNumberGroup computerBallGroup;

    public BaseBallManager() {
        generateBaseBall();
    }

    private void generateBaseBall() {
        computerBallGroup = new BallNumberGroup(generateUniqueRandomNumbers());
        computerBallInfo = new HashMap<>();
        List<BallNumber> computerBall = computerBallGroup.getBallNumberGroup();
        for (int bIdx = 0; bIdx < GameMessage.BALL_NUMBER_GROUP_SIZE.getNumber(); bIdx++) {
            computerBallInfo.put(computerBall.get(bIdx).getNumber(), bIdx);
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

        for (int bIdx = 0; bIdx < GameMessage.BALL_NUMBER_GROUP_SIZE.getNumber(); bIdx++) {
            Integer playerBall = playerBalls.get(bIdx).getNumber();
            if (!computerBallInfo.containsKey(playerBall)) {
                compareResult.put(GameMessage.NOTHING.getMessage(), compareResult.getOrDefault(GameMessage.NOTHING.getMessage(), 0) + 1);
            } else {
                if (bIdx == computerBallInfo.get(playerBall)) {
                    compareResult.put(GameMessage.STRIKE.getMessage(), compareResult.getOrDefault(GameMessage.STRIKE.getMessage(), 0) + 1);
                } else if (bIdx != computerBallInfo.get(playerBall)) {
                    compareResult.put(GameMessage.BALL.getMessage(), compareResult.getOrDefault(GameMessage.BALL.getMessage(), 0) + 1);
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

        while (computer.size() < GameMessage.BALL_NUMBER_GROUP_SIZE.getNumber()) {
            Integer randomNumber = Randoms.pickNumberInRange(GameMessage.MIN_NUMBER.getNumber(), GameMessage.MAX_NUMBER.getNumber());
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
