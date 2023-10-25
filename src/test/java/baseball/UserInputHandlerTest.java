package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputHandlerTest extends NsTest {

    @DisplayName("입력값 예외 테스트")
    @Test
    void 입력값_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("strike"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}