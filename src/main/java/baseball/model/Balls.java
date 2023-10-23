package baseball.model;

import baseball.util.NumberConstant;
import java.util.List;
import java.util.Objects;

public class Balls {

    private final int ballCount;

    public Balls(RandomNumbers randomNumbers, UserInputNumbers userInputNumbers) {
        int counts = countBalls(randomNumbers, userInputNumbers);
        validateCountRange(counts);
        this.ballCount = counts;
    }

    private void validateCountRange(int strikeCount) {
        if (strikeCount < 0 || strikeCount > 3) {
            throw new IllegalArgumentException("볼 갯수는 0에서 3사이 입니다");
        }
    }

    public int countBalls(RandomNumbers randomNumbers, UserInputNumbers userInputNumbers) {
        int counts = 0;
        List<Number> randomNumberList = randomNumbers.getRandomNumbers();
        List<Number> userInputNumberList = userInputNumbers.getUserNumberList();

        for (int i = 0; i < NumberConstant.LENGTH; i++) {
            Number randomNumber = randomNumberList.get(i);
            Number userInputNumber = userInputNumberList.get(i);

            if (isBall(randomNumberList, userInputNumber, randomNumber)) {
                counts += 1;
            }
        }
        return counts;
    }

    private boolean isBall(List<Number> randomNumberList, Number userInputNumber, Number randomNumber) {
        return randomNumberList.contains(userInputNumber) && !isStrike(randomNumber, userInputNumber);
    }

    private boolean isStrike(Number userInputNumber, Number randomNumber) {
        return userInputNumber.equals(randomNumber);
    }

    public int getBallCount() {
        return ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Balls balls = (Balls) o;
        return ballCount == balls.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballCount);
    }
}
