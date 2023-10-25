package baseball;

import java.util.Objects;

public class Number {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private final int number;

	public Number(int number) {
		validate(number);
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Number number = (Number) o;
		return this.number == number.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	private void validate(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException("1 ~ 9 사이의 숫자여야 합니다.");
		}
	}
}
