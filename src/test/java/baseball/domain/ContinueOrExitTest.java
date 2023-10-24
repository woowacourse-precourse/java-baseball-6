package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ContinueOrExitTest {

    @DisplayName("사용자가 입력한 값이 1 또는 2 의 한자리 숫자면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void fromSuccessTest(String input) {
        assertThatCode(() -> ContinueOrExit.from(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력한 값이 1 또는 2 의 한자리 숫자가 아니라면 IllegalArgumentException 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideFromFailTestArgument")
    void fromFailTest(String input, String message) {
        assertThatCode(() -> ContinueOrExit.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    static Stream<Arguments> provideFromFailTestArgument() {
        return Stream.of(
                arguments("", "입력값은 1 또는 2 만 가능합니다."),
                arguments("123", "입력값은 1 또는 2 만 가능합니다."),
                arguments("asdf", "입력값은 1 또는 2 만 가능합니다."),
                arguments("3", "입력값은 1 또는 2 만 가능합니다.")
        );
    }

    @DisplayName("사용자가 입력한 값이 1 또는 2 의 한자리 숫자가 아니라면 IllegalArgumentException 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideIsContinueTestArgument")
    void isContinueTest(String input, boolean expected) {
        ContinueOrExit decision = ContinueOrExit.from(input);
        assertThat(decision.isContinue()).isEqualTo(expected);
    }

    static Stream<Arguments> provideIsContinueTestArgument() {
        return Stream.of(
                arguments("1", true),
                arguments("2", false)
        );
    }
}
