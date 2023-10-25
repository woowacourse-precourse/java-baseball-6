package baseball.domain;

import static baseball.utils.ErrorMessages.NOT_INVALID_RETRY_INPUT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Command Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CommandTest {

    private static Stream<Arguments> provideCommand() {
        return Stream.of(
                Arguments.of("1", Command.RETRY),
                Arguments.of("2", Command.QUIT)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCommand")
    void of_메소드는_유효한_입력값이_주어지면_Command를_반환한다(String command, Command expect) {
        Assertions.assertEquals(Command.of(command), expect);
    }

    @ParameterizedTest
    @MethodSource("provideCommand")
    void of_메소드는_유효하지_않은_입력값이_주어지면_예외를_던진다(String command, Command expect) {
        assertThatThrownBy(() -> Command.of("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INVALID_RETRY_INPUT);
    }

    @Test
    void isRetry_메소드는_해당_Command가_Retry이면_true를_반환한다() {
        Command command = Command.RETRY;
        Assertions.assertEquals(command.isRetry(), true);
    }

    @Test
    void isRetry_메소드는_해당_Command가_Retry가_아니면_false를_반환한다() {
        Command command = Command.QUIT;
        Assertions.assertEquals(command.isRetry(), false);
    }
}
