package baseball.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @DisplayName("사용자가 입력한 값이 1~9 범위의 서로다른 3자리 숫자면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456"})
    void validateBaseBallNumberSuccessTest(String input) {
        assertThatCode(() -> InputValidator.validateBaseBallNumber(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력한 값이 1~9 범위의 서로다른 3자리 숫자가 아니라면 IllegalArgumentException 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideValidateBaseBallNumberFailTestArgument")
    void validateBaseBallNumberFailTest(String input, String message) {
        assertThatCode(() -> InputValidator.validateBaseBallNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    static Stream<Arguments> provideValidateBaseBallNumberFailTestArgument() {
        return Stream.of(
                arguments("1", "입력값은 3자리 수만 가능합니다."),
                arguments("1234", "입력값은 3자리 수만 가능합니다."),
                arguments("112", "입력값은 중복되지 않는 서로 다른 숫자만 가능합니다."),
                arguments("가나다", "입력값은 1~9 범위의 숫자만 가능합니다."),
                arguments("abc", "입력값은 1~9 범위의 숫자만 가능합니다.")
        );
    }

    @DisplayName("사용자가 입력한 값이 1 또는 2 의 한자리 숫자면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void validateContinueOrExitNumberSuccessTest(String input) {
        assertThatCode(() -> InputValidator.validateContinueOrExitNumber(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력한 값이 1 또는 2 의 한자리 숫자가 아니라면 IllegalArgumentException 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideValidateContinueOrExitNumberTestArgument")
    void validateContinueOrExitNumberFailTest(String input, String message) {
        assertThatCode(() -> InputValidator.validateContinueOrExitNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    static Stream<Arguments> provideValidateContinueOrExitNumberTestArgument() {
        return Stream.of(
                arguments("", "입력값은 한 자리 수만 입력 가능합니다."),
                arguments("123", "입력값은 한 자리 수만 입력 가능합니다."),
                arguments("asdf", "입력값은 한 자리 수만 입력 가능합니다."),
                arguments("3", "입력값은 1 또는 2 만 가능합니다.")
        );
    }
}
