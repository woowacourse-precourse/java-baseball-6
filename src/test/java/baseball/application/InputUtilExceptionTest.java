package baseball.application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("입력 기능 예외 테스트")
class InputUtilExceptionTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"  ", "", "\n"})
    void 공백_입력_값_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"eng", "한국어", "#$%", "very looooooooong"})
    void 문자열_입력_값_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
