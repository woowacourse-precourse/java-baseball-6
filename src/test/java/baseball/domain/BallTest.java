package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

	@Test
	@DisplayName("스트라이크인 경우")
	void givenBall_whenIsStrike_thenReturnTrue() {
		// given
		Ball ball = new Ball(1, 0);

		// when
		boolean result = ball.isStrike(new Ball(1, 0));

		// then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("스트라이크가 아닌 경우")
	void givenBall_whenIsStrike_thenReturnFalse() {
		// given
		Ball ball = new Ball(1, 0);

		// when
		boolean result = ball.isStrike(new Ball(1, 2));

		// then
		assertThat(result).isFalse();
	}

}
