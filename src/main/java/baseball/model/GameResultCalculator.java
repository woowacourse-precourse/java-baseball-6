package baseball.model;

public class GameResultCalculator {

    private static final String BALL_RESULT = "볼";
    private static final String STRIKE_RESULT = "스트라이크";
    private static final String NOTHING_RESULT = "낫싱";
    private static final String BLANK = " ";

    public int countStrike(Number random, Number input) {
        int strikeCount = 0;

        if (random.firstDigit == input.firstDigit) {
            strikeCount++;
        }

        if (random.secondDigit == input.secondDigit) {
            strikeCount++;
        }

        if (random.thirdDigit == input.thirdDigit) {
            strikeCount++;
        }

        return strikeCount;

    }

    public int countBall(Number random, Number input) {
        int ballCount = 0;

        if (random.firstDigit != input.firstDigit && random.contains(input.firstDigit)) {
            ballCount++;
        }

        if (random.secondDigit != input.secondDigit && random.contains(input.secondDigit)) {
            ballCount++;
        }

        if (random.thirdDigit != input.thirdDigit && random.contains(input.thirdDigit)) {
            ballCount++;
        }

        return ballCount;
    }


    public boolean isThreeStrike(Number randomNumber, Number inputNumber) {
        return randomNumber.firstDigit == inputNumber.firstDigit
                && randomNumber.secondDigit == inputNumber.secondDigit
                && randomNumber.thirdDigit == inputNumber.thirdDigit;
    }

    public String makeGameResult(Number randomNumber, Number inputNumber) {
        int ballCount = countBall(randomNumber, inputNumber);
        int strikeCount = countStrike(randomNumber, inputNumber);

        return resultToString(ballCount, strikeCount);
    }

    public String resultToString(int ballCount, int strikeCount) {
        if (ballCount != 0 && strikeCount != 0) {
            return ballCount + BALL_RESULT + BLANK + strikeCount + STRIKE_RESULT;
        }

        if (ballCount != 0) {
            return ballCount + BALL_RESULT;
        }

        if (strikeCount != 0) {
            return strikeCount + STRIKE_RESULT;
        }

        return NOTHING_RESULT;
    }
}
