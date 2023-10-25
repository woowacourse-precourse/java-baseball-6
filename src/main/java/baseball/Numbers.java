package baseball;

import java.util.List;

public class Numbers {

	private static final int SIZE_NUMBERS = 3;

	private final List<Number> numbers;

	public Numbers(List<Number> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Number> numbers) {
		if (numbers.size() != SIZE_NUMBERS) {
			throw new IllegalArgumentException("3자리 이여야 합니다.");
		}
	}

	public int getIndex(Number number) {
		return numbers.indexOf(number);
	}

	public boolean isContain(Number number) {
		return numbers.contains(number);
	}

	public List<Number> getBalls() {
		return numbers;
	}

}


