package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.domain.balls.Balls;

class GameResultMessageTest {

	@ParameterizedTest
	@MethodSource("createMessageData")
	@DisplayName("게임 결과 메시지 생성")
	void givenGameResult_whenCreateMessage_thenReturnCorrectMessage(Balls playerBalls, String expected) {
		// given
		Referee referee = new Referee();
		Balls computerBalls = new Balls(List.of(1, 2, 3));
		GameResult gameResult = referee.judge(computerBalls, playerBalls);

		// when
		String result = GameResultMessage.createMessage(gameResult);

		// then
		assertThat(result).isEqualTo(expected);
	}

	private static Stream<Arguments> createMessageData() {
		return Stream.of(
				Arguments.of(new Balls(List.of(2, 8, 9)), "1볼"),
				Arguments.of(new Balls(List.of(8, 2, 9)), "1스트라이크"),
				Arguments.of(new Balls(List.of(9, 2, 1)), "1볼 1스트라이크"),
				Arguments.of(new Balls(List.of(7, 8, 9)), "낫싱")
		);
	}

}
