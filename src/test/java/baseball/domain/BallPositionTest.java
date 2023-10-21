package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallPositionTest {

	@Test
	@DisplayName("1자리 게임 숫자의 위치 동등성 판단 통과")
	void givenPosition_whenEquals_thenReturnTrue() {
		// given
		BallPosition ballPosition = new BallPosition(1);

		// when
		boolean result = ballPosition.equals(new BallPosition(1));

		// then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("1자리 게임 숫자의 위치 동등성 판단 실패")
	void givenPosition_whenEquals_thenReturnFalse() {
		// given
		BallPosition ballPosition = new BallPosition(1);

		// when
		boolean result = ballPosition.equals(new BallPosition(0));

		// then
		assertThat(result).isFalse();
	}

}
