package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	@DisplayName("게임 종료/재시작 입력 검증 통과")
	void givenInput_whenValidateGameCommand_thenNoException(String input) {
		assertThatNoException().isThrownBy(() -> GameCommand.validate(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "3", "12", "!", "q"})
	@DisplayName("게임 종료/재시작 입력 검증 통과")
	void givenInput_whenValidateGameCommand_thenThrowIllegalArgumentException(String input) {
		assertThatThrownBy(() -> GameCommand.validate(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1(재시작) 또는 2(종료)를 입력해주세요.");
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
	@DisplayName("게임 재시작 여부 판단: 1(재시작), 2(종료)")
	void givenCommandInput_whenIsReplayCommand_thenReturnTrueOrFalse(String input, boolean expected) {
		// when
		boolean result = GameCommand.isReplayCommand(input);

		// then
		assertThat(result).isEqualTo(expected);
	}

}
