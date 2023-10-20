package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BallNumbersTest {

    @ParameterizedTest
    @MethodSource("generateInvalidSizedNumbers")
    @DisplayName("야구 숫자의 개수가 3개가 아니면 예외가 발생한다.")
    void hasInvalidSize_Then_ExceptionOccurs(final List<Integer> numbers) {
        assertThatThrownBy(() -> new BallNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateInvalidSizedNumbers() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3, 4))
        );
    }

    @Test
    @DisplayName("중복된 야구 숫자가 있으면 예외가 발생한다.")
    void existDuplicateNumbers_Then_ExceptionOccurs() {
        assertThatThrownBy(() -> new BallNumbers(List.of(1, 1, 1)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BallNumbers(List.of(2, 5, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 숫자가 존재하지 않으면 낫싱이다.")
    void doesNotExistsSameNumber_Then_Nothing() {
        BallNumbers player = new BallNumbers(List.of(7, 8, 9));
        BallNumbers computer = new BallNumbers(List.of(4, 2, 5));
        PlayResult playResult = player.compareAll(computer);
        assertThat(playResult.isNothing()).isTrue();
    }

    @ParameterizedTest
    @MethodSource("generateComputerNumbers")
    @DisplayName("같은 숫자가 같은 자리에 존재하면 스트라이크이다.")
    void existsSameNumberInSamePosition_Then_Strike(
            final BallNumbers computerNumbers,
            final long numberOfStrikes
    ) {
        BallNumbers player = new BallNumbers(List.of(1, 2, 3));
        PlayResult playResult = player.compareAll(computerNumbers);
        assertThat(playResult.getStrikes()).isEqualTo(numberOfStrikes);
    }

    @ParameterizedTest
    @MethodSource("generateComputerNumbers")
    @DisplayName("같은 숫자가 다른 자리에 존재하면 볼이다.")
    void existsSameNumberInSamePosition_Then_Ball(
            final BallNumbers computerNumbers,
            final long numberOfStrikes
    ) {
        BallNumbers player = new BallNumbers(List.of(3, 1, 2));
        PlayResult playResult = player.compareAll(computerNumbers);
        assertThat(playResult.getBalls()).isEqualTo(numberOfStrikes);
    }

    private static Stream<Arguments> generateComputerNumbers() {
        return Stream.of(
                Arguments.of(new BallNumbers(List.of(4, 2, 5)), 1L),
                Arguments.of(new BallNumbers(List.of(4, 2, 3)), 2L),
                Arguments.of(new BallNumbers(List.of(1, 2, 3)), 3L)
        );
    }
}
