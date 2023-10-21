package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 9})
	@DisplayName("1자리 게임 숫자의 숫자 동등성 판단 통과")
	void givenNumber_whenEquals_thenReturnTrue(int number) {
		// given
		BallNumber ballNumber = new BallNumber(number);

		// when
		boolean result = ballNumber.equals(new BallNumber(number));

		// then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("1자리 게임 숫자의 숫자 동등성 판단 실패")
	void givenNumber_whenEquals_thenReturnFalse() {
		// given
		BallNumber ballNumber = new BallNumber(1);

		// when
		boolean result = ballNumber.equals(new BallNumber(9));

		// then
		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 10})
	@DisplayName("1자리 게임 숫자의 숫자 검증 예외 처리: 숫자 범위")
	void givenNumber_whenValidate_thenThrownIllegalArgumentException(int number) {
		assertThatThrownBy(() -> new BallNumber(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("1 부터 9 사이의 숫자가 아닙니다.");
	}

}
