package baseball;

import java.util.List;

public class Judge {
    private JugeResult jugeResult = new JugeResult();

    private static final int START_ROUND = 1;
    private static final int END_ROUND = 3;

    public void init() {
        jugeResult.clear();
    }

    public JugeResult inProgress(List<Ball> computerBaseBall, List<Ball> playerBaseBall) {
        init();

        for (int i = START_ROUND - 1; i < END_ROUND; i++) {
            Ball computer = computerBaseBall.get(i);
            Ball player = playerBaseBall.get(i);

            isBall(computer, playerBaseBall);
            isStrike(computer, player);
        }

        return jugeResult;
    }
    public boolean isSuccessed() {
        return jugeResult.isSuccess();
    }

    private void isBall(Ball computer, List<Ball> playerBaseBall) {
        for (int i = START_ROUND - 1; i < END_ROUND; i++) {
            Ball player = playerBaseBall.get(i);
            if (computer.equals(player)) jugeResult.incrementBall();
        }
    }

    private void isStrike(Ball computer, Ball player) {
        if (computer.equals(player)) jugeResult.incrementStrike();
    }
}
