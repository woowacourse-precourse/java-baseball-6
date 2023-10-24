package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CommandTest {

    @DisplayName("게임 재시작/종료 입력 정상 테스트")
    @ParameterizedTest(name = "{index} {displayName} value={0}, {1}")
    @MethodSource("validateCommandParametersProvider")
    void checkValidateCommand(String value, Command command) {
        assertThat(Command.fromValue(value)).isEqualTo(command);
    }

    @DisplayName("게임 재시작/종료 입력 예외 테스트")
    @ParameterizedTest(name = "{index} {displayName} value={0}")
    @ValueSource(strings = {"3", "0", "", "abd"})
    void checkInvalidateCommand(String value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Command.fromValue(value));

    }

    static Stream<Arguments> validateCommandParametersProvider() {
        return Stream.of(
                Arguments.arguments("1", Command.RESTART),
                Arguments.arguments("2", Command.QUIT)
        );
    }
}