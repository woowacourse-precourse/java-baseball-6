package baseball.domain;

import java.util.Objects;

public class BallPosition {

	private static final int MIN = 0;
	private static final int MAX = 2;
	private static final String POSITION_RANGE_ERROR_MESSAGE = "0 부터 2 사이의 숫자가 아닙니다.";

	private final int position;

	public BallPosition(final int position) {
		validate(position);
		this.position = position;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BallPosition that = (BallPosition)o;
		return position == that.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	private void validate(final int position) {
		if (position < MIN || position > MAX) {
			throw new IllegalArgumentException(POSITION_RANGE_ERROR_MESSAGE);
		}
	}

}
