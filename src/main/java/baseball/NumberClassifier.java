package baseball;

public abstract class NumberClassifier {
    private int ballCount = 0;
    private int strikeCount = 0;

    protected int getBallCount(){
        return ballCount;
    }

    protected int getStrikeCount(){
        return strikeCount;
    }

    protected void writeBallsCount(int playerNumbers, int partnerNumbers) {
        int[] ballsCount = getBallsCount(playerNumbers, partnerNumbers);
        int allCount = ballsCount[0];
        int strikeCount = ballsCount[1];
        int ballCount = getBallCount(allCount, strikeCount);

        setBallsCount(strikeCount, ballCount);
    }

    private int getBallCount(int allMatchCount, int strikeCount) {
        if (allMatchCount - strikeCount < 0) {
            return 0;
        } else {
            return allMatchCount - strikeCount;
        }
    }

    private void setBallsCount(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    private int[] getBallsCount(int playerNumbers, int partnerNumbers){
        int[] ballsCount = new int[2];

        while (playerNumbers % 10 > 0) {
            int playerNumber = playerNumbers % 10;
            int partnerNumber = partnerNumbers % 10;

            if (checkBallStrike(playerNumber)) {
                ballsCount[0]++;
            }

            if (checkStrike(playerNumber, partnerNumber)) {
                ballsCount[1]++;
            }

            playerNumbers /= 10;
            partnerNumbers /= 10;
        }

        return ballsCount;
    }

    protected abstract boolean checkStrike(int playerNumber, int partnerNumber);

    protected abstract boolean checkBallStrike(int playerNumber);

}
