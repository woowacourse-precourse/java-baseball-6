package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.Retry;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RetryTest {

    public static Stream<Arguments> retry() {
        return Stream.of(
            Arguments.of("1", Retry.RETRY),
            Arguments.of("2", Retry.QUIT)
        );
    }

    @ParameterizedTest
    @MethodSource("retry")
    void _1을_입력하면_retry(String retrySymbol, Retry retry) {
        assertThat(Retry.from(retrySymbol)).isEqualTo(retry);
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "a", "a A"})
    void _다른문자를_입력하면_예외(String retrySymbol) {
        assertThatThrownBy(() -> Retry.from(retrySymbol))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @EmptySource
    void _공백을_입력하면_예외(String nullAndEmpty) {
        assertThatThrownBy(() -> Retry.from(nullAndEmpty))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
