package baseball;

import java.util.List;

public class Judge {
    private JudgeResult judgeResult = new JudgeResult();

    private static final int START_ROUND = 1;
    private static final int END_ROUND = 3;

    public void init() {
        judgeResult.clear();
    }

    public JudgeResult inProgress(List<Ball> computerBaseBall, List<Ball> playerBaseBall) {
        init();

        for (int i = START_ROUND - 1; i < END_ROUND; i++) {
            Ball computer = computerBaseBall.get(i);
            Ball player = playerBaseBall.get(i);

            judging(playerBaseBall, computer, player);
        }

        return judgeResult;
    }

    private void judging(List<Ball> playerBaseBall, Ball computer, Ball player) {
        if (isStrike(computer, player)) {
            judgeResult.incrementStrike();
            return;
        }
        if (isBall(computer, playerBaseBall)) {
            judgeResult.incrementBall();
        }
    }

    public boolean isSuccessed() {
        return judgeResult.isSuccess();
    }

    private boolean isBall(Ball computer, List<Ball> playerBaseBall) {
        for (int i = START_ROUND - 1; i < END_ROUND; i++) {
            Ball player = playerBaseBall.get(i);
            if (computer.equals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrike(Ball computer, Ball player) {
        if (computer.equals(player)) {
            return true;
        }
        return false;
    }
}
