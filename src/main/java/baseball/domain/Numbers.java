package baseball.domain;

import static baseball.domain.NumbersValidator.validateDuplicateNumber;
import static baseball.domain.NumbersValidator.validateNumberRange;
import static baseball.domain.NumbersValidator.validateNumbersSize;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    private Numbers(List<Integer> inputNumbers) {
        validateNumbersSize(inputNumbers);
        validateDuplicateNumber(inputNumbers);
        validateNumberRange(inputNumbers);
        this.numbers = inputNumbers;
    }

    public static Numbers createRandomNumbers() {
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        return new Numbers(randomNumbersGenerator.generateRandomNumbers());
    }

    public static Numbers fromInputNumbers(List<Integer> inputNumbers) {
        return new Numbers(inputNumbers);
    }

    public boolean isSamePosition(Numbers inputNumbers, int position) {
        return valueOfIndex(position).equals(inputNumbers.valueOfIndex(position));
    }

    public boolean isSameNumber(Numbers inputNumbers, int position) {
        return numbers.contains(inputNumbers.valueOfIndex(position)) && !isSamePosition(inputNumbers, position);
    }

    private Integer valueOfIndex(int position) {
        return numbers.get(position);
    }
}
