package baseball.domain.player.defender.value;

import java.util.Objects;

public class BallCount {

	private static final Long BALL_COUNT_EMPTY = 0L;
	private final Long count;

	public BallCount(Long ballCount) {
		this.count = ballCount;
	}

	public boolean isEmpty() {
		return Objects.equals(count, BALL_COUNT_EMPTY);
	}

	public Long getCount() {
		return count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BallCount ballCount1 = (BallCount) o;
		return Objects.equals(count, ballCount1.count);
	}

	@Override
	public int hashCode() {
		return Objects.hash(count);
	}
}
