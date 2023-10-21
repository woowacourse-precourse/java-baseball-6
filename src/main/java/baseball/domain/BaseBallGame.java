package baseball.domain;

import baseball.constant.GameStatus;

public class BaseBallGame {

    private final Computer computer;
    private GameStatus status;

    public BaseBallGame(Computer computer) {
        this.computer = computer;
        this.status = GameStatus.START;
    }

    public GameResult getBallCount(Player player) {
        GameResult gameResult = computer.calculateBallCount(player);
        status = GameStatus.PROGRESS;
        if (gameResult.isThreeStrike()) {
            status = GameStatus.THREE_STRIKE;
        }
        return gameResult;
    }

    public boolean isProgress() {
        return status.isProgress();
    }
}
