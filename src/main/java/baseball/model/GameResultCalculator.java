package baseball.model;

public class GameResultCalculator {
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
}
