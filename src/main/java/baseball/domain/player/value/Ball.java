package baseball.domain.player.value;

import java.util.Objects;

public class Ball {

	private final Long value;

	private Ball(Long value) {
		this.value = value;
	}

	public static Ball of(Long value) {
		return new Ball(value);
	}

	public Long getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Ball ball = (Ball) o;
		return Objects.equals(value, ball.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
