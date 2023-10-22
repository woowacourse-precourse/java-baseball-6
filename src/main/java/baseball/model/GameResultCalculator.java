package baseball.model;

public class GameResultCalculator {
    public int countStrike(Number random, Number input) {
        int strikeCount = 0;

        if (random.firstNumber == input.firstNumber) {
            strikeCount++;
        }

        if (random.secondNumber == input.secondNumber) {
            strikeCount++;
        }

        if (random.thirdNumber == input.thirdNumber) {
            strikeCount++;
        }

        return strikeCount;

    }

    public int countBall(Number random, Number input) {
        int ballCount = 0;

        if (random.firstNumber != input.firstNumber && random.contains(input.firstNumber)) {
            ballCount++;
        }

        if (random.secondNumber != input.secondNumber && random.contains(input.secondNumber)) {
            ballCount++;
        }

        if (random.thirdNumber != input.thirdNumber && random.contains(input.thirdNumber)) {
            ballCount++;
        }

        return ballCount;
    }


    public boolean isThreeStrike(Number randomNumber, Number inputNumber) {
        return randomNumber.equals(inputNumber);
    }
}
