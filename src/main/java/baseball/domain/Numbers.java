package baseball.domain;

import static baseball.domain.NumbersValidator.*;

import java.util.List;

import java.util.stream.IntStream;

public class Numbers {
	private static final int NUMBERS_LENGTH = 3;
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

	public int countStrike(Numbers inputNumbers) {
		return (int)IntStream.range(0, NUMBERS_LENGTH)
			.filter(i -> numbers.get(i).equals(inputNumbers.numbers.get(i)))
			.count();
	}
}
