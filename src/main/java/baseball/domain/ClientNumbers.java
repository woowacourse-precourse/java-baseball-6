package baseball.domain;

import java.util.Collections;
import java.util.List;

public class ClientNumbers {

	private final List<Integer> numbers;

	public ClientNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}
}
