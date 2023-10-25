package baseball.domain.balls;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

	private Ball ball;

	@BeforeEach
	void init() {
		ball = new Ball(1, 0);
	}

	@Test
	@DisplayName("스트라이크인 경우")
	void givenBall_whenIsStrike_thenReturnTrue() {
		// when
		boolean result = ball.isStrike(new Ball(1, 0));

		// then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("스트라이크가 아닌 경우")
	void givenBall_whenIsStrike_thenReturnFalse() {
		// when
		boolean result = ball.isStrike(new Ball(1, 2));

		// then
		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("볼인 경우")
	void givenBall_whenIsBall_thenReturnTrue() {
		// when
		boolean result = ball.isBall(new Ball(1, 2));

		// then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("볼이 아닌 경우")
	void givenBall_whenIsBall_thenReturnFalse() {
		// when
		boolean result = ball.isBall(new Ball(9, 0));

		// then
		assertThat(result).isFalse();
	}

}
