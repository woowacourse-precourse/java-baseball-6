package baseball.domain;

import static baseball.domain.NumbersValidator.*;

import java.util.List;
import java.util.Objects;
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
			.filter(i -> valueOfIndex(i).equals(inputNumbers.valueOfIndex(i)))
			.count();
	}

	public int countBall(Numbers inputNumbers) {
		return (int)IntStream.range(0, NUMBERS_LENGTH)
			.filter(i -> numbers.contains(inputNumbers.valueOfIndex(i)))
			.filter(i -> !Objects.equals(valueOfIndex(i), inputNumbers.valueOfIndex(i)))
			.count();
	}

	private Integer valueOfIndex(int position) {
		return numbers.get(position);
	}
}
