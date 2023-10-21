package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private List<BaseballNumber> ballNumbers;

    public BaseballNumbers(List<Integer> numbers) {
        this.ballNumbers = new ArrayList<>();
        createBaseballNumbers(numbers);
    }

    public BaseballNumbers(String userInput) {
        this.ballNumbers = new ArrayList<>();
        createBaseballNumbers(userInput);
    }

    public void createBaseballNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            BaseballNumber baseballNumber = new BaseballNumber(number);
            ballNumbers.add(baseballNumber);
        }
    }

    public void createBaseballNumbers(String userInput) {
        for (int i = 0; i < 3; i++) {
            char userInputNumber = userInput.charAt(i);
            BaseballNumber userBaseballNumber = new BaseballNumber(userInputNumber);
            ballNumbers.add(userBaseballNumber);
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

    public int getBallCount(BaseballNumbers inputBaseballNumbers) {
        int ballCount = 0;
        List<BaseballNumber> baseballNumberList = this.ballNumbers;
        for (int i = 0; i < 3; i++) {
            BaseballNumber baseballNumber = baseballNumberList.get(i);
            BaseballNumber inputBaseballNumber = inputBaseballNumbers.ballNumbers.get(i);
            if (baseballNumberList.contains(inputBaseballNumber) && !baseballNumber.equals(inputBaseballNumber)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    public boolean isNothing(BaseballNumbers inputBaseballNumbers) {
        List<BaseballNumber> baseballNumberList = this.ballNumbers;
        for (int i = 0; i < 3; i++) {
            BaseballNumber inputBaseballNumber = inputBaseballNumbers.ballNumbers.get(i);
            if (baseballNumberList.contains(inputBaseballNumber)) {
                return false;
            }
        }
        return true;
    }
}