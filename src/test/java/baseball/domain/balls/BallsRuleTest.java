package baseball.domain.balls;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallsRuleTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 9})
	@DisplayName("게임 숫자 규칙: 게임 숫자가 범위를 벗어났나? No")
	void givenNumber_whenIsNumberOutOfRange_thenReturnFalse(int number) {
		// when
		boolean result = BallsRule.isNumberOutOfRange(number);

		// then
		assertThat(result).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 10})
	@DisplayName("게임 숫자 규칙: 게임 숫자가 범위를 벗어났나? Yes")
	void givenNumber_whenIsNumberOutOfRange_thenReturnTrue(int number) {
		// when
		boolean result = BallsRule.isNumberOutOfRange(number);

		// then
		assertThat(result).isTrue();
	}

}
