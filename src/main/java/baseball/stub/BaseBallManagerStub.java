package baseball.stub;

import baseball.model.BallNumber;
import baseball.model.BallNumberGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseBallManagerStub {
    private static BallNumberGroup computerBallGroup;
    private static Map<Integer, Integer> stubComputerBallInfo;
    private static Map<String, Integer> stubPlayerResult;

    public void setComputerBaseBallNumber(BallNumberGroup ballNumberGroup) {
        this.computerBallGroup = ballNumberGroup;
        stubComputerBallInfo = new HashMap<>();
        List<BallNumber> computerBall = computerBallGroup.getBallNumberGroup();
        for (int ballIdx = 0; ballIdx < 3; ballIdx++) {
            stubComputerBallInfo.put(computerBall.get(ballIdx).getNumber(), ballIdx);
        }
    }

    public Map<String, Integer> compareBaseBall(BallNumberGroup playerBallGroup) {
        stubPlayerResult = new HashMap<>();
        List<BallNumber> playerBalls = playerBallGroup.getBallNumberGroup();
        int nothingCount = 0;

        for (int ballIdx = 0; ballIdx < 3; ballIdx++) {
            Integer playerBall = playerBalls.get(ballIdx).getNumber();
            if (!stubComputerBallInfo.containsKey(playerBall)) {
                nothingCount++;
            } else {
                if (ballIdx == stubComputerBallInfo.get(playerBall)) {
                    stubPlayerResult.put("스트라이크", stubPlayerResult.getOrDefault("스트라이크", 0) + 1);
                } else if (ballIdx != stubComputerBallInfo.get(playerBall)) {
                    stubPlayerResult.put("볼", stubPlayerResult.getOrDefault("볼", 0) + 1);
                }
            }
        }

        if (nothingCount == 3) stubPlayerResult.put("낫싱", 1);

        return stubPlayerResult;
    }
}
