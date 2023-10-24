package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<BallCount, Integer> result;

    public Result(Map<BallCount, Integer> result) {
        this.result = result;
    }

    public static Result initialBallCount() {
        Map<BallCount, Integer> result = new HashMap<>();
        result.put(BallCount.BALL, 0);
        result.put(BallCount.STRIKE, 0);
        result.put(BallCount.NOTHING, 0);
        return new Result(result);
    }


    public void updateBallCount(BallCount ballCount) {
        result.put(ballCount, result.get(ballCount) + 1);
    }

    public int getResultByBallCount(BallCount ballCount) {
        return result.get(ballCount);
    }

    public Map<BallCount, Integer> getResult() {
        return result;
    }

    public String getFormattedResult() {
        int strike = result.get(BallCount.STRIKE);
        int ball = result.get(BallCount.BALL);
        if (strike == 0 && ball == 0) {
            return BallCount.NOTHING.getBaseballjudgment();
        }
        StringBuilder gameResult = new StringBuilder();
        if (ball > 0) {
            gameResult.append("" + ball + BallCount.BALL.getBaseballjudgment());
        }
        if (ball > 0 && strike > 0) {
            gameResult.append(" ");
        }
        if (strike > 0) {
            gameResult.append("" + strike + BallCount.STRIKE.getBaseballjudgment());
        }
        return gameResult.toString();
    }
}