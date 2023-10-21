package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Balls {

	private static final int MIN = 1;
	private static final int MAX = 9;
	private static final int SIZE = 3;
	private static final int MIN_POSITION = 0;
	private static final int MAX_POSITION = 2;
	private static final String NUMBER_RANGE_ERROR_MESSAGE = "1 부터 9 사이의 숫자가 아닙니다.";
	private static final String NUMBERS_SIZE_ERROR_MESSAGE = "3개의 숫자가 아닙니다.";
	private static final String NUMBERS_DUPLICATION_ERROR_MESSAGE = "중복된 숫자가 존재합니다.";

	private final List<Ball> balls;

	public Balls(final List<Integer> numbers) {
		validate(numbers);
		this.balls = mapToBalls(numbers);
	}

	public void validate(final List<Integer> numbers) {
		validateNumberRange(numbers);
		validateNumbersSize(numbers);
		validateDuplication(numbers);
	}

	private void validateNumberRange(final List<Integer> numbers) {
		numbers.stream()
			   .filter(number -> number < MIN || number > MAX)
			   .forEach(number -> {
				   throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
			   });
	}

	private void validateNumbersSize(final List<Integer> numbers) {
		if (numbers.size() != SIZE) {
			throw new IllegalArgumentException(NUMBERS_SIZE_ERROR_MESSAGE);
		}
	}

	private void validateDuplication(final List<Integer> numbers) {
		if (getCountWithoutDuplication(numbers) != SIZE) {
			throw new IllegalArgumentException(NUMBERS_DUPLICATION_ERROR_MESSAGE);
		}
	}

	private int getCountWithoutDuplication(final List<Integer> numbers) {
		return new HashSet<>(numbers).size();
	}

	private List<Ball> mapToBalls(final List<Integer> numbers) {
		return IntStream.rangeClosed(MIN_POSITION, MAX_POSITION)
						.mapToObj(position -> new Ball(numbers.get(position), position))
						.toList();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Balls otherBalls = (Balls)o;
		return Objects.equals(balls, otherBalls.balls);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balls);
	}

}
