package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RefereeTest {

	@ParameterizedTest
	@MethodSource("compareData")
	@DisplayName("게임 숫자를 비교해 결과를 생성")
	void givenTwoBalls_whenCompare_thenReturnGameResult(List<Integer> numbers, int strikeResult, int ballResult) {
		// given
		Referee referee = new Referee();
		Balls computerBalls = new Balls(List.of(1, 2, 3));
		Balls playerBalls = new Balls(numbers);

		// when
		GameResult result = referee.compare(computerBalls, playerBalls);

		// then
		assertThat(result.getStrikeCount()).isEqualTo(strikeResult);
		assertThat(result.getBallCount()).isEqualTo(ballResult);
	}

	private static Stream<Arguments> compareData() {
		return Stream.of(
			Arguments.of(List.of(1, 4, 5), 1, 0),
			Arguments.of(List.of(2, 4, 5), 0, 1),
			Arguments.of(List.of(1, 3, 5), 1, 1)
		);
	}

	@ParameterizedTest
	@MethodSource("notifyGameResultData")
	@DisplayName("게임 결과를 메시지로 생성")
	void givenGameResult_whenNotifyGameResult_thenReturnMessage(List<Integer> numbers, String expected) {
		// given
		Referee referee = new Referee();
		Balls computerBalls = new Balls(List.of(1, 2, 3));
		Balls playerBalls = new Balls(numbers);

		// when
		String result = referee.notifyGameResult(referee.compare(computerBalls, playerBalls));

		// then
		assertThat(result).isEqualTo(expected);
	}

	private static Stream<Arguments> notifyGameResultData() {
		return Stream.of(
			Arguments.of(List.of(1, 4, 5), "1스트라이크"),
			Arguments.of(List.of(2, 4, 5), "1볼"),
			Arguments.of(List.of(1, 3, 5), "1볼 1스트라이크"),
			Arguments.of(List.of(4, 5, 6), "낫싱")
		);
	}

}
