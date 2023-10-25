package baseball.domain;

import java.util.Collections;
import java.util.List;

public class RandomNumbers {

	private final List<Integer> numbers;

	public RandomNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}
}
