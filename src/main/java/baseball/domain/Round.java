package baseball.domain;

public final class Round {
    private int ballCount = 0;
    private int strikeCount = 0;

    public Round(ComputerNumbers computerNumbers, UserNumbers userNumbers) {
        calculateRoundResult(computerNumbers, userNumbers);
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean hasBall() {
        return ballCount != 0;
    }

    public boolean hasStrike() {
        return strikeCount != 0;
    }

    public boolean isGameEnd() {
        return strikeCount == 3;
    }

    private void countStrike(int i, ComputerNumbers computerNumbers, UserNumbers userNumbers) {
        if (computerNumbers.get(i) == userNumbers.get(i)) {
            strikeCount++;
        }
    }

    private void countBall(int i, ComputerNumbers computerNumbers, UserNumbers userNumbers) {
        int userNumber = userNumbers.get(i);
        if (computerNumbers.get(i) == userNumbers.get(i) && computerNumbers.contains(userNumber)) {
            ballCount++;
        }
    }

    private void calculateRoundResult(ComputerNumbers computerNumbers, UserNumbers userNumbers) {
        for (int i = 0; i < 3; i++) {
            countStrike(i, computerNumbers, userNumbers);
            countBall(i, computerNumbers, userNumbers);
        }
    }

}

