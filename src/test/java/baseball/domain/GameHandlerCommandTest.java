package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameHandlerCommandTest {
    @DisplayName("게임 커맨드는 1또는 2여야한다.")
    @ParameterizedTest
    @MethodSource("createCommandData")
    void 게임_커맨드는_1_2(String command, GameHandlerCommand gameHandlerCommand) {
        GameHandlerCommand findCommand = GameHandlerCommand.findCommand(command);
        Assertions.assertThat(findCommand).isEqualTo(gameHandlerCommand);
    }

    static Stream<Arguments> createCommandData() {
        return Stream.of(
                Arguments.of("1", GameHandlerCommand.RESTART),
                Arguments.of("2", GameHandlerCommand.STOP)
        );
    }

    @DisplayName("게임 커맨드는 1,2외 에는 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("createExceptionData")
    void 게임_커맨드는_1_2외에는_예외(String command) {
        assertThrows(IllegalArgumentException.class, () -> {
            GameHandlerCommand.findCommand(command);
        });
    }
    static Stream<Arguments> createExceptionData() {
        return Stream.of(
                Arguments.of("3"),
                Arguments.of("4")
        );
    }

}