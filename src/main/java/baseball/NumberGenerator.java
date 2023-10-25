package baseball;

import java.util.List;

public class NumberGenerator {

	private NumberGenerator() {
	}

	public static Number generateBall(Integer number) {
		return new Number(number);
	}

	public static List<Number> generateBall(List<Integer> numbers) {
		return numbers.stream()
				.map(NumberGenerator::generateBall)
				.toList();
	}
}
