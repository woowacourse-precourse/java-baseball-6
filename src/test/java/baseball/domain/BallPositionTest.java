package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@ParameterizedTest
	@ValueSource(ints = {-1, 3})
	@DisplayName("1자리 게임 숫자의 위치 검증 예외 처리: 위치 범위")
	void givenWrongPosition_whenValidate_thenThrowIllegalArgumentException(int position) {
		assertThatThrownBy(() -> new BallPosition(position))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("0 부터 2 사이의 숫자가 아닙니다.");
	}

}
