package baseball.domain;

import static baseball.domain.Constants.NUMBER_OF_BASEBALL;

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
        validateInputIsThreeNumber(userInput);
        validateNoDuplicateNumber(userInput);
        createBaseballNumbers(userInput);
    }

    public void createBaseballNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            BaseballNumber baseballNumber = new BaseballNumber(number);
            ballNumbers.add(baseballNumber);
        }
    }

    public void createBaseballNumbers(String userInput) {
        for (int i = 0; i < NUMBER_OF_BASEBALL; i++) {
            char userInputNumber = userInput.charAt(i);
            BaseballNumber userBaseballNumber = new BaseballNumber(userInputNumber);
            ballNumbers.add(userBaseballNumber);
        }
    }

    public void validateInputIsThreeNumber(String userInput) {
        if (!userInput.matches("^[0-9]{3}$")) {
            throw new IllegalArgumentException("입력은 정확히 세 자리 숫자여야 합니다.");
        }
    }

    public void validateNoDuplicateNumber(String userInput) {
        for (int i = 0; i < NUMBER_OF_BASEBALL; i++) {
            char number = userInput.charAt(i);
            if (userInput.indexOf(number) != i) {
                throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
            }
        }
    }

    public int getStrikeCount(BaseballNumbers inputBaseballNumbers) {
        int strikeCount = 0;

        for (int i = 0; i < NUMBER_OF_BASEBALL; i++) {
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

        for (int i = 0; i < NUMBER_OF_BASEBALL; i++) {
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

        for (int i = 0; i < NUMBER_OF_BASEBALL; i++) {
            BaseballNumber inputBaseballNumber = inputBaseballNumbers.ballNumbers.get(i);
            if (baseballNumberList.contains(inputBaseballNumber)) {
                return false;
            }
        }

        return true;
    }
}