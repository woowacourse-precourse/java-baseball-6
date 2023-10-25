package baseball.domain;

import baseball.status.CompareStatus;

public class CompareSystem {
    private final GameResult result;
    private final ComputerNumbers computerNumbers;
    private final PlayerNumbers playerNumbers;

    public CompareSystem(ComputerNumbers computerNumbers, PlayerNumbers playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
        this.result = new GameResult();
    }

    public GameResult compare() {
        for(int index = 0; index < 3; index++) {
            CompareStatus compareStatus = checkStatus(index);
            int compareCount = result.get(compareStatus);
            result.putCount(compareStatus, compareCount);
        }
        return result;
    }

    private CompareStatus checkStatus(int index) {
        if(isNumberComputerContains(index)) {
            return checkBallOrStrike(index);
        }
        return CompareStatus.NOTHING;
    }

    private CompareStatus checkBallOrStrike(int index) {
        if(isSamePositionAndSameNumber(index)) {
            return CompareStatus.STRIKE;
        }
        return CompareStatus.BALL;
    }

    private boolean isSamePositionAndSameNumber(int index) {
        return computerNumbers.get(index) == playerNumbers.get(index);
    }

    private boolean isNumberComputerContains(int index) {
        return computerNumbers.contains(playerNumbers.get(index));
    }
}
