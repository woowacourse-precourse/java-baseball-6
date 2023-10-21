package baseball.domain;

import java.util.Objects;

public class BallPosition {

	private final int position;

	public BallPosition(final int position) {
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

}
