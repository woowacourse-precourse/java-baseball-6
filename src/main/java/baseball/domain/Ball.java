package baseball.domain;

import java.util.Objects;

public class Ball {

	private final BallNumber ballNumber;
	private final BallPosition ballPosition;

	public Ball(final int number, final int position) {
		this.ballNumber = new BallNumber(number);
		this.ballPosition = new BallPosition(position);
	}

	public boolean isStrike(final Ball ball) {
		return this.equals(ball);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Ball ball = (Ball)o;
		return Objects.equals(ballNumber, ball.ballNumber)
			&& Objects.equals(ballPosition, ball.ballPosition);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ballNumber, ballPosition);
	}

}
