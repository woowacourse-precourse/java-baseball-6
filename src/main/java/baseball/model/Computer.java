package baseball.model;

import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MAX_DIGIT_COUNT = 3;
    private List<Integer> numbers;

    public List<Integer> generateRandomNumbers() {
        List<Integer> nums = new ArrayList<>();

        while (nums.size() < MAX_DIGIT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            if (!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }
        return nums;
    }

    public List<Integer> getNumbers() {
        if (this.numbers == null || this.numbers.isEmpty()) {
            numbers = this.generateRandomNumbers();
        }
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        String convertedStr = InputValidator.convertListToString(numbers);
        InputValidator.validatePlayerNumberInput(convertedStr);

        this.numbers = numbers;
    }
}
