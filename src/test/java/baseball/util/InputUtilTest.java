package baseball.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputUtilTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"1234", "  ", "abcb", "가나다", "12", "1"})
    void 유효하지_않은_숫자입력시_예외발생(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "  ", "abcb", "가나다", "12"})
    void 유효하지_않은_리플레이명령어_입력시_예외발생(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("246", "135", "1", "597", "589", input))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
