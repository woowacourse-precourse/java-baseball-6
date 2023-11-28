package baseball.unitTest;

import static baseball.model.restarter.RestartState.END_GAME;
import static baseball.model.restarter.RestartState.RESTART_GAME;
import static org.assertj.core.api.Assertions.*;

import baseball.model.restarter.RestartState;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[RestartState] 재시작 테스트")
public class RestartTest {

    @Nested
    @DisplayName("[validate] 입력 값 검증")
    class ValidateTest {

        static Stream<Arguments> provideInput() {
            return Stream.of(
                    Arguments.of("숫자가 아닐 경우 예외가 발생한다", "a"),
                    Arguments.of("1혹은 2가 아닐 경우 예외가 발생한다", "0")
            );
        }

        @ParameterizedTest(name = "[EXCEPTION] {0}")
        @MethodSource("provideInput")
        @DisplayName("[validate] 입력 값 검증")
        void should_throwException_when_isNumeric(String message, String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> RestartState.findState(input));
        }
    }

    @Nested
    @DisplayName("[utility] 상태")
    class UtilityTest {

        static Stream<Arguments> provideInputState() {
            return Stream.of(
                    Arguments.of("1", "1일 경우 RESTART_GAME을 반환한다", RESTART_GAME),
                    Arguments.of("2", "2일 경우 END_GAME을 반환한다", END_GAME)
            );
        }

        @ParameterizedTest(name = "{index}: {1}")
        @MethodSource("provideInputState")
        @DisplayName("[SUCCESS] 상태 변환 테스트")
        void should_success_when_stateTest(String input, String message, RestartState result) {
            assertThat(RestartState.findState(input)).isEqualTo(result);
        }

        @Test
        @DisplayName("[SUCCESS] 상태가 END_GAME일 경우 참을 반환한다")
        void should_success_when_isENDGAME() {
            assertThat(END_GAME.isEndGame())
                    .isTrue();
        }
    }
}
