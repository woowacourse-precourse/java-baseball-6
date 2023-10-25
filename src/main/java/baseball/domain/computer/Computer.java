package baseball.domain.computer;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Computer {

	private final Map<Integer, Integer> numbers;

	Computer(final Map<Integer, Integer> numbers) {
		this.numbers = numbers;
	}

	public Map<Integer, Integer> numbers() {
		return Collections.unmodifiableMap(numbers);
	}

	public String compare(final List<Integer> numbers) {
		return BallResult.generateResult(numbers, this.numbers);
	}
}
