package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class GameCommandTest {

    @Test
    void 입력으로_1을_입력하면_재시작을_생성한다() {
        // given
        GameCommand gameCommand = GameCommand.createFromInput("1");

        // when
        boolean isRestart = GameCommand.isRestartCommand(gameCommand);

        // then
        assertThat(isRestart).isTrue();
    }

    @Test
    void 입력으로_2를_입력하면_종료를_생성한다() {
        // given
        GameCommand gameCommand = GameCommand.createFromInput("2");

        // when
        boolean isRestart = GameCommand.isRestartCommand(gameCommand);

        // then
        assertThat(isRestart).isFalse();
    }

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("invalidParameters")
    void 잘못된_입력으로_생성시에_예외가_발생한다(String input, String expectedExceptionMessage, String exceptionMessage) {
        // when & then
        assertThatThrownBy(() -> GameCommand.createFromInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
                Arguments.of("3", "1또는 2를 입력해주세요", "다른 숫자를 입력하면 예외가 발생한다."),
                Arguments.of("ad", "1또는 2를 입력해주세요", "숫자말고 다른 값을 입력하면 예외가 발생한다.")
        );
    }
}
