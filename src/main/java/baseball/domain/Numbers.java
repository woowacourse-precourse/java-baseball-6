package baseball.domain;

import static baseball.domain.NumbersValidator.*;

import java.util.List;

public class Numbers {

	private final List<Integer> numbers;

	public Numbers(List<Integer> inputNumbers) {
		validateNumbersSize(inputNumbers);
		validateDuplicateNumber(inputNumbers);
		validateNumberRange(inputNumbers);
		this.numbers = inputNumbers;
	}

	public Numbers() {
		RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
		this.numbers = randomNumbersGenerator.generateRandomNumbers();
	}

	public boolean isSamePosition(Numbers inputNumbers ,int position) {
		return valueOfIndex(position).equals(inputNumbers.valueOfIndex(position));
	}

	public boolean isSameNumber(Numbers inputNumbers, int position) {
		return numbers.contains(inputNumbers.valueOfIndex(position)) && !isSamePosition(inputNumbers,position);
	}

	private Integer valueOfIndex(int position) {
		return numbers.get(position);
	}
}
