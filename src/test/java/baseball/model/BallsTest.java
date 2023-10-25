package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BallsTest {

    @ParameterizedTest
    @MethodSource("generateInvalidSizedNumbers")
    @DisplayName("야구 숫자의 개수가 3개가 아니면 예외가 발생한다.")
    void hasInvalidSize_Then_ExceptionOccurs(final List<Integer> numbers) {
        assertThatThrownBy(() -> new Balls(numbers))
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
        assertThatThrownBy(() -> new Balls(List.of(1, 1, 1)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Balls(List.of(2, 5, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비교 결과가 낫싱인지 판별할 수 있다.")
    void doesNotExistsSameNumber_Then_Nothing() {
        Balls player = new Balls(List.of(7, 8, 9));
        Balls computer = new Balls(List.of(4, 2, 5));
        CompareResults compareResults = computer.compareAll(player);
        assertThat(compareResults.isNothing()).isTrue();
    }

    @ParameterizedTest
    @MethodSource("generatePlayerNumbers")
    @DisplayName("비교 결과에서 스트라이크의 개수를 구할 수 있다.")
    void hasSameNumberInSamePosition_Then_NumberOfStrikesObtain(
            final Balls playerNumbers,
            final long numberOfStrikes
    ) {
        Balls computer = new Balls(List.of(1, 2, 3));
        CompareResults compareResults = computer.compareAll(playerNumbers);
        assertThat(compareResults.getStrikes()).isEqualTo(numberOfStrikes);
    }

    @ParameterizedTest
    @MethodSource("generatePlayerNumbers")
    @DisplayName("비교 결과에서 볼의 개수를 구할 수 있다.")
    void hasSameNumberInDifferentPosition_Then_NumberOfBallsObtain(
            final Balls playerNumbers,
            final long numberOfStrikes
    ) {
        Balls computer = new Balls(List.of(3, 1, 2));
        CompareResults compareResults = computer.compareAll(playerNumbers);
        assertThat(compareResults.getBalls()).isEqualTo(numberOfStrikes);
    }

    private static Stream<Arguments> generatePlayerNumbers() {
        return Stream.of(
                Arguments.of(new Balls(List.of(4, 2, 5)), 1L),
                Arguments.of(new Balls(List.of(4, 2, 3)), 2L),
                Arguments.of(new Balls(List.of(1, 2, 3)), 3L)
        );
    }

    @Test
    @DisplayName("비교 결과가 모두 스트라이크인지 판별할 수 있다.")
    void isAllSameNumber_Then_AllStrike() {
        Balls player = new Balls(List.of(3, 1, 2));
        CompareResults compareResults = player.compareAll(new Balls(List.of(3, 1, 2)));
        assertThat(compareResults.isAllStrike()).isTrue();
    }
}
