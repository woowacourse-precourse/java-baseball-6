package baseball;

public abstract class NumberClassifier {
    private int ballCount = 0;
    private int strikeCount = 0;

    protected int getBallCount() {
        return this.ballCount;
    }

    protected int getStrikeCount() {
        return this.strikeCount;
    }

    protected void compareNumbers(int playerNumbers, int partnerNumbers) {
        int[] ballsCount = getBallsCount(playerNumbers, partnerNumbers);
        int allCount = ballsCount[0];
        int strikeCount = ballsCount[1];
        int ballCount = getBallCount(allCount, strikeCount);

        setBallsCount(strikeCount, ballCount);
    }

    private int[] getBallsCount(int playerNumbers, int partnerNumbers) {
        int[] ballsCount = new int[2];

        while (playerNumbers % 10 > 0) {
            int playerNumber = playerNumbers % 10;
            int partnerNumber = partnerNumbers % 10;

            if (validateBallStrike(playerNumber)) {
                ballsCount[0]++;
            }

            if (validateStrike(playerNumber, partnerNumber)) {
                ballsCount[1]++;
            }

            playerNumbers /= 10;
            partnerNumbers /= 10;
        }

        return ballsCount;
    }

    protected abstract boolean validateBallStrike(int playerNumber);

    protected abstract boolean validateStrike(int playerNumber, int partnerNumber);

    private int getBallCount(int allCount, int strikeCount) {
        if (allCount - strikeCount < 0) {
            return 0;
        } else {
            return allCount - strikeCount;
        }
    }

    private void setBallsCount(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

}
