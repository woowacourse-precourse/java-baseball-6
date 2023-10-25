package baseball.domain.computer;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.domain.computer.BallResult;

class BallResultTest {

	@ParameterizedTest
	@MethodSource("values")
	@DisplayName("컴퓨터와 유저의 숫자를 넣으면 적절한 결과를 반환한다.")
	void inputTest(final List<Integer> userNumbers, final Map<Integer, Integer> computerNumbers, final String result) {
		//given
		final String expected = BallResult.generateResult(userNumbers, computerNumbers);

		//expected
		assertThat(result).isEqualTo(expected);
	}

	private static Stream<Arguments> values() {
		return Stream.of(
			Arguments.of(
				List.of(1, 2, 3),
				Map.of(1, 0, 2, 1, 3, 2),
				"3스트라이크"
			),
			Arguments.of(
				List.of(3, 1, 2),
				Map.of(3, 2, 2, 1, 1, 0),
				"3볼"
			),
			Arguments.of(
				List.of(5, 7, 8),
				Map.of(3, 2, 2, 1, 1, 0),
				"낫싱"
			),
			Arguments.of(
				List.of(1, 2, 3),
				Map.of(1, 0, 4, 1, 2, 2),
				"1볼 1스트라이크"
			),
			Arguments.of(
				List.of(1, 2, 3),
				Map.of(1, 0, 4, 1, 3, 2),
				"2스트라이크"
			),
			Arguments.of(
				List.of(1, 2, 3),
				Map.of(2, 0, 1, 1, 3, 2),
				"2볼 1스트라이크"
			)
		);
	}
}
