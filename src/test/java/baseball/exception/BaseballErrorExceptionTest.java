package baseball.exception;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballErrorExceptionTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("results")
    void 입력값에_맞는_예외_메세지를_만든다(String name, BaseballErrorMessage message,
                             Object[] args, String expected) {
        BaseballGameException exception = new BaseballGameException(message, args);

        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expected);
    }

    static Stream<Arguments> results() {
        return Stream.of(
                Arguments.of("입력값 길이 오류", BaseballErrorMessage.INVALID_NUMBER_LENGTH,
                        new Object[]{3}, "숫자는 3자리여야 합니다."),
                Arguments.of("중복된 숫자 오류", BaseballErrorMessage.DUPLICATED_NUMBER,
                        new Object[]{}, "서로 다른 숫자여야 합니다."),
                Arguments.of("입력값 범위 오류", BaseballErrorMessage.INVALID_NUMBER_RANGE,
                        new Object[]{1, 9}, "1 ~ 9 사이의 숫자여야 합니다."),
                Arguments.of("재시작/종료 입력값 오류", BaseballErrorMessage.INVALID_RESTART_NUMBER,
                        new Object[]{}, "재시작(1)/종료(2) 입력은 1 또는 2만 가능합니다."),
                Arguments.of("입력값 null/빈값 오류", BaseballErrorMessage.NULL_OR_BLANK_INPUT,
                        new Object[]{}, "입력한 값이 null 혹은 빈값입니다.")
        );
    }
}