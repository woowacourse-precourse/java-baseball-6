package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallsTest {

	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	@DisplayName("3자리 게임 숫자 검증 통과")
	void givenNumbers_whenValidate_thenNoException(String input) {
		// given
		List<Integer> numbers = Arrays.stream(input.split(""))
									  .map(Integer::parseInt)
									  .toList();

		// when & then
		assertThatNoException().isThrownBy(() -> new Balls(numbers));
	}

	@Test
	@DisplayName("3자리 게임 숫자 검증 예외 처리: 범위를 벗어난 경우")
	void givenNumbers_whenValidateNumberRange_thenThrowIllegalArgumentException() {
		assertThatThrownBy(() -> new Balls(List.of(1, 0, 9)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("1 부터 9 사이의 숫자가 아닙니다.");
	}

	@Test
	@DisplayName("3자리 게임 숫자 검증 예외 처리: 3개의 숫자가 아닌 경우")
	void givenNumbers_whenValidateSize_thenThrowIllegalArgumentException() {
		assertThatThrownBy(() -> new Balls(List.of(1, 2)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("3개의 숫자가 아닙니다.");
	}

}
