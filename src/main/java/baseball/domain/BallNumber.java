package baseball.domain;

import java.util.Objects;

public class BallNumber {

	private static final int MIN = 1;
	private static final int MAX = 9;
	private static final String NUMBER_RANGE_ERROR_MESSAGE = "1 부터 9 사이의 숫자가 아닙니다.";

	private final int number;

	public BallNumber(final int number) {
		validate(number);
		this.number = number;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BallNumber that = (BallNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	private void validate(int number) {
		if (number < MIN || number > MAX) {
			throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
		}
	}

}
