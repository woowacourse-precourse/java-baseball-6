package baseball.model;

import baseball.enums.NumberEnum;

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수
 * @param firstNumber 첫 번째 숫자
 * @param secondNumber 두 번째 숫자
 * @param thirdNumber 세 번째 숫자
 */
public record NumberModel(
        int firstNumber,
        int secondNumber,
        int thirdNumber
) {
    public NumberModel {
        if (NumberEnum.isNotInRange(firstNumber)) {
            throw new IllegalArgumentException("첫 번째 숫자는 1~9 사이의 숫자여야 합니다.");
        }

        if (NumberEnum.isNotInRange(secondNumber)) {
            throw new IllegalArgumentException("두 번째 숫자는 1~9 사이의 숫자여야 합니다.");
        }

        if (NumberEnum.isNotInRange(thirdNumber)) {
            throw new IllegalArgumentException("세 번째 숫자는 1~9 사이의 숫자여야 합니다.");
        }

        if (firstNumber == secondNumber || secondNumber == thirdNumber || thirdNumber == firstNumber) {
            throw new IllegalArgumentException("숫자는 서로 중복되지 않아야 합니다.");
        }
    }

    /**
     * 두 NumberModel을 비교하여 HintModel을 반환
     * @param numberModel 비교할 NumberModel
     * @return HintModel
     */
    public HintModel compare(NumberModel numberModel) {
        int strike = calculateStrikes(numberModel);
        int ball = calculateBalls(numberModel);

        return new HintModel(strike, ball);
    }

    private int calculateStrikes(NumberModel numberModel) {
        int strikes = 0;

        if (firstNumber == numberModel.firstNumber()) {
            strikes++;
        }
        if (secondNumber == numberModel.secondNumber()) {
            strikes++;
        }
        if (thirdNumber == numberModel.thirdNumber()) {
            strikes++;
        }

        return strikes;
    }

    private int calculateBalls(NumberModel numberModel) {
        int balls = 0;

        int[] thisNumbers = {firstNumber, secondNumber, thirdNumber};
        int[] otherNumbers = {numberModel.firstNumber(), numberModel.secondNumber(), numberModel.thirdNumber()};

        for (int i = 0; i < thisNumbers.length; i++) {
            if (thisNumbers[i] != otherNumbers[i] && contains(thisNumbers, otherNumbers[i], i)) {
                balls++;
            }
        }

        return balls;
    }

    private boolean contains(int[] numbers, int target, int excludeIndex) {
        for (int i = 0; i < numbers.length; i++) {
            if (i != excludeIndex && numbers[i] == target) {
                return true;
            }
        }

        return false;
    }
}