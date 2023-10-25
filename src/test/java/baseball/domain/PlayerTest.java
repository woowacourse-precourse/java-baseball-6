package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	@DisplayName("플레이어 생성 성공")
	void givenNumbers_whenCreatePlayer_thenNoException(String numbers) {
		assertThatNoException().isThrownBy(() -> new Player(numbers));
	}

	@ParameterizedTest
	@ValueSource(strings = {"12삼", "1@3", "12e"})
	@DisplayName("플레이어 생성 실패: 잘못된 입력이 들어오면 예외 발생")
	void givenInput_whenValidateNumber_thenThrowIllegalArgumentException(String input) {
		assertThatThrownBy(() -> new Player(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("숫자가 아닙니다.");
	}

}
