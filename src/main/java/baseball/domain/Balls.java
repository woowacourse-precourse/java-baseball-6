package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	private static final int MIN = 1;
	private static final int MAX = 9;
	private static final String NUMBER_RANGE_ERROR_MESSAGE = "1 부터 9 사이의 숫자가 아닙니다.";

	private final List<Ball> balls;

	public Balls(final List<Integer> numbers) {
		validate(numbers);
		this.balls = mapToBalls(numbers);
	}

	public void validate(final List<Integer> numbers) {
		validateNumberRange(numbers);
	}

	private void validateNumberRange(final List<Integer> numbers) {
		numbers.stream()
			   .filter(number -> number < MIN || number > MAX)
			   .forEach(number -> {
				   throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
			   });
	}

	private List<Ball> mapToBalls(final List<Integer> numbers) {
		return new ArrayList<>();
	}

}
