package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	void givenNumbers_whenCreatePlayer_thenNoException(String numbers) {
		assertThatNoException().isThrownBy(() -> new Player(numbers));
	}

}
