package baseball.model;

public class GameResultCalculator {

    private static final String BALL_RESULT = "볼";
    private static final String STRIKE_RESULT = "스트라이크";
    private static final String NOTHING_RESULT = "낫싱";
    private static final String BLANK = " ";
    private int ballCount;
    private int strikeCount;

    public GameResultCalculator() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void makeGameResult(Number randomNumber, Number inputNumber) {
        initCount();
        countBall(randomNumber, inputNumber);
        countStrike(randomNumber, inputNumber);
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }
정
    public String toString() {
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

    private void initCount() {
        ballCount = 0;
        strikeCount = 0;
    }


    private void countBall(Number random, Number input) {
        if (random.firstDigit != input.firstDigit && random.contains(input.firstDigit)) {
            ballCount++;
        }

        if (random.secondDigit != input.secondDigit && random.contains(input.secondDigit)) {
            ballCount++;
        }

        if (random.thirdDigit != input.thirdDigit && random.contains(input.thirdDigit)) {
            ballCount++;
        }

    }

    private void countStrike(Number random, Number input) {
        if (random.firstDigit == input.firstDigit) {
            strikeCount++;
        }

        if (random.secondDigit == input.secondDigit) {
            strikeCount++;
        }

        if (random.thirdDigit == input.thirdDigit) {
            strikeCount++;
        }
    }

}
