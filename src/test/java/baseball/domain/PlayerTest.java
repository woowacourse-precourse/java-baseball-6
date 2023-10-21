package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

	@Test
	@DisplayName("플레이어의 Balls 업데이트 성공")
	void givenPlayer_whenChangeBalls_thenUpdateSuccess() {
		// given
		Player originPlayer = new Player("123");

		// when
		Player updatedPlayer = originPlayer.updateBalls("456");

		// then
		assertThat(updatedPlayer.getBalls()).isEqualTo(new Balls(List.of(4, 5, 6)));
	}

}
