package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private List<BaseballNumber> ballNumbers;

    public BaseballNumbers(List<Integer> numbers) {
        this.ballNumbers = new ArrayList<>();
        createBaseballNumbers(numbers);
    }

    public void createBaseballNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            BaseballNumber baseballNumber = new BaseballNumber(number);
            ballNumbers.add(baseballNumber);
        }
    }

    public int getStrikeCount(BaseballNumbers inputBaseballNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            BaseballNumber baseballNumber = ballNumbers.get(i);
            BaseballNumber inputBaseballNumber = inputBaseballNumbers.ballNumbers.get(i);
            if (baseballNumber.equals(inputBaseballNumber)) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }
}