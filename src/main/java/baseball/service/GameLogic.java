package baseball.service;

import baseball.dto.Result;

public class GameLogic {
    public void play(int[] playerNumberBall, int[] computerNumberBall, Result result) {
        for (int i = 1; i < 10; i++) {
            ballCount(playerNumberBall, computerNumberBall, result, i);
            strikeCount(playerNumberBall, computerNumberBall, result, i);
        }
        answerCheck(result);
    }

    public void ballCount(int[] playerNumberBall, int[] computerNumberBall, Result result, int idx) {

        if (computerNumberBall[idx] != 0 && playerNumberBall[idx] != 0
                && computerNumberBall[idx] != playerNumberBall[idx]) {
            result.setBall(result.getBall() + 1);
        }

    }

    public void strikeCount(int[] playerNumberBall, int[] computerNumberBall, Result result, int idx) {

        if (computerNumberBall[idx] != 0 && computerNumberBall[idx] == playerNumberBall[idx]) {
            result.setStrike(result.getStrike() + 1);

        }

    }

    public void answerCheck(Result result) {
        if (result.getStrike() == 3) {
            result.setCondition(Result.ANSWER);
        }
    }

    public void resultClear(Result result) {
        if (result.isCondition() == Result.WRONG) {
            result.setBall(0);
            result.setStrike(0);
        }
    }
}
