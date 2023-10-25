package baseball.domain;

import baseball.global.utils.generator.NumberGenerator;
import java.util.List;

public class Computer {

	private final RandomNumbers numbers;

	public Computer(NumberGenerator numberGenerator) {
		numbers = new RandomNumbers(numberGenerator.generate());
	}

	public List<Integer> getNumbers() {
		return numbers.getNumbers();
	}
}
