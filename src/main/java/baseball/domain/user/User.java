package baseball.domain.user;

import java.util.Collections;
import java.util.List;

import baseball.domain.computer.Computer;

public class User {

	private final List<Integer> numbers;
	private final String result;

	public User(final Computer computer, final List<Integer> numbers)  {
		this.numbers = numbers;
		this.result = computer.compare(numbers);
	}

	public List<Integer> numbers() {
		return Collections.unmodifiableList(numbers);
	}

	public String result() {
		return result;
	}
}
