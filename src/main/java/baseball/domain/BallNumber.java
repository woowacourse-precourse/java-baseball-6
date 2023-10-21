package baseball.domain;

import java.util.Objects;

public class BallNumber {

	private final int number;

	public BallNumber(final int number) {
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

}
