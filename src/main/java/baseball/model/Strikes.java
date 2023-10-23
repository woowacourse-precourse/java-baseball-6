package baseball.model;

import baseball.util.NumberConstant;
import java.util.List;
import java.util.Objects;

public class Strikes {

    private final int strikeCount;

    public Strikes(RandomNumbers randomNumbers, UserInputNumbers userInputNumbers) {
        int counts = countStrikes(randomNumbers, userInputNumbers);
        validateCountRange(counts);
        this.strikeCount = counts;
    }

    private void validateCountRange(int strikeCount) {
        if (strikeCount < 0 || strikeCount > 3) {
            throw new IllegalArgumentException("스트라이크 갯수는 0에서 3사이 입니다");
        }
    }

    private int countStrikes(RandomNumbers randomNumbers, UserInputNumbers userInputNumbers) {
        int counts = 0;
        List<Number> randomNumberList = randomNumbers.getRandomNumbers();
        List<Number> userInputNumberList = userInputNumbers.getUserNumberList();

        for (int i = 0; i < NumberConstant.LENGTH; i++) {
            Number randomNumber = randomNumberList.get(i);
            Number userInputNumber = userInputNumberList.get(i);

            if (isStrike(userInputNumber, randomNumber)) {
                counts += 1;
            }
        }
        return counts;
    }

    private boolean isStrike(Number userInputNumber, Number randomNumber) {
        return userInputNumber.equals(randomNumber);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Strikes strikes = (Strikes) o;
        return strikeCount == strikes.strikeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount);
    }
}
