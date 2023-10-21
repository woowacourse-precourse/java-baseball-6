package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	void givenNumbers_whenCreatePlayer_thenNoException(String numbers) {
		assertThatNoException().isThrownBy(() -> new Player(numbers));
	}

	@ParameterizedTest
	@ValueSource(strings = {"12삼", "1@3", "12e"})
	void givenInput_whenValidateNumber_thenThrowIllegalArgumentException(String input) {
		assertThatThrownBy(() -> new Player(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("숫자가 아닙니다.");
	}

}
