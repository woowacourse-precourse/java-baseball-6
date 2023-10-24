package baseball.domain.player.defender.value;

import java.util.Objects;

public class StrikeCount {

	private static final Long BALL_COUNT_EMPTY = 0L;
	private static final Long STRIKE_COUNT_THREE = 3L;

	private final Long count;

	public StrikeCount(Long strikeCount) {
		this.count = strikeCount;
	}

	public boolean isEmpty() {
		return Objects.equals(count, BALL_COUNT_EMPTY);
	}

	public boolean isThreeStrike() {
		return Objects.equals(count, STRIKE_COUNT_THREE);
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
		StrikeCount that = (StrikeCount) o;
		return Objects.equals(count, that.count);
	}

	@Override
	public int hashCode() {
		return Objects.hash(count);
	}
}
