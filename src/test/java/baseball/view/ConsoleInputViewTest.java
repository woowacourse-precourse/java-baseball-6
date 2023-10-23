package baseball.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import baseball.exception.consoleView.ConsoleInputBlankException;
import baseball.exception.consoleView.ConsoleInputCanNotChangeToIntException;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class ConsoleInputViewTest extends NsTest {

    @MethodSource("wrongInputProvider")
    @ParameterizedTest(name = "{0}")
    void 입력_값이_비어있으면_예외를_발생시킨다(String message, String text, Class<? extends Throwable> expected) {
        // when & then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(text))
                        .isInstanceOf(expected)
        );
    }

    private static Stream<Arguments> wrongInputProvider() {
        return Stream.of(
                Arguments.of("입력이 비었을 경우", " ", ConsoleInputBlankException.class),
                Arguments.of("입력이 숫자가 아닌 문자인 경우", "test", ConsoleInputCanNotChangeToIntException.class));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
