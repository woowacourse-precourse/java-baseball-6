package baseball.domain;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ClientNumbersTest {

	@DisplayName("올바른 값을 입력하면 성공한다.")
	@Test
	void should_success_when_validNumbers() {
		List<Integer> numbers = List.of(1, 2, 3);
		ClientNumbers clientNumbers = new ClientNumbers(numbers);

		Assertions.assertThat(clientNumbers.getNumbers()).containsExactly(numbers.toArray(new Integer[0]));
	}

	@DisplayName("올바르지 않은 값을 입력하면 예외를 반환한다.")
	@ParameterizedTest
	@MethodSource("invalidParametersProvider")
	void should_exception_when_invalidNumbers(List<Integer> numbers) {
		Assertions.assertThatThrownBy(() -> new ClientNumbers(numbers));
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
