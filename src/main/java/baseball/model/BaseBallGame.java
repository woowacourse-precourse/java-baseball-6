package baseball.model;

import baseball.util.constants.BaseballGameConstants;

public class BaseBallGame {

    private final Computer computer;
    private BallCount currentBallCount;

    private BaseBallGame(Computer computer) {
        this.computer = computer;
        this.currentBallCount = new BallCount(0, 0);
    }

    public static BaseBallGame start() {
        return new BaseBallGame(new Computer());
    }

    public BallCount getCurrentBallCount() {
        return this.currentBallCount;
    }

    public boolean isWin() {
        return currentBallCount.strike() == BaseballGameConstants.NUM_LENGTH;
    }

    public void inputAndCalculateBallCount(Numbers input) {
        currentBallCount = computer.getNumbers().compare(input);
    }
}
