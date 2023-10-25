package baseball.domain.service;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import baseball.domain.Client;
import baseball.domain.Computer;
import baseball.global.constant.OutputType;
import baseball.global.utils.generator.IntendedNumberGenerator;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballServiceTest {

	private final BaseballService baseballService = new BaseballService();

	@DisplayName("컴퓨터와 사용자의 수에 따라 Client의 ballCount, strikeCount가 달라진다.")
	@ParameterizedTest
	@MethodSource("validParametersProvider")
	void should_changeBallCountAndStrikeCount_when_numberOfComputerAndClientDiffer(
			List<Integer> computerNumbers,
			List<Integer> clientNumbers,
			int ballCount,
			int strikeCount
	) {
		Computer computer = new Computer(new IntendedNumberGenerator(computerNumbers));
		Client client = new Client(new IntendedNumberGenerator(clientNumbers));
		baseballService.playRound(computer, client);

		Assertions.assertThat(client.getBallCount()).isEqualTo(ballCount);
		Assertions.assertThat(client.getStrikeCount()).isEqualTo(strikeCount);
	}

	@DisplayName("올바르지 않은 입력을 하면 예외가 반환된다.")
	@ParameterizedTest
	@MethodSource("invalidParametersProvider")
	void should_throwException_when_invalidNumbersGiven(List<Integer> clientNumbers) {
		Assertions.assertThatThrownBy(() -> new Client(new IntendedNumberGenerator(clientNumbers)))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(OutputType.EXCEPTION.getComment());
	}

	static Stream<Arguments> validParametersProvider() {
		return Stream.of(
				arguments(List.of(1, 2, 3), List.of(4, 5, 6), 0, 0),
				arguments(List.of(1, 2, 3), List.of(4, 1, 5), 1, 0),
				arguments(List.of(1, 2, 3), List.of(3, 1, 4), 2, 0),
				arguments(List.of(1, 2, 3), List.of(3, 1, 2), 3, 0),
				arguments(List.of(1, 2, 3), List.of(1, 4, 5), 0, 1),
				arguments(List.of(1, 2, 3), List.of(1, 2, 4), 0, 2),
				arguments(List.of(1, 2, 3), List.of(1, 2, 3), 0, 3),
				arguments(List.of(1, 2, 3), List.of(1, 4, 2), 1, 1),
				arguments(List.of(1, 2, 3), List.of(1, 3, 2), 2, 1)
		);
	}

	static Stream<Arguments> invalidParametersProvider() {
		return Stream.of(
				arguments(List.of(1, 2, 3, 4)),
				arguments(List.of(-1, 4, 5)),
				arguments(List.of(0, 1, 2)),
				arguments(List.of(1, 1, 2)),
				arguments(List.of(1, 2, 10))
		);
	}
}
