package baseball.exception;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ExceptionTest extends NsTest {

    @Test
    void 숫자가_2개만_들어옴() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("12"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_다른값이_들어옴() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("한글"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void _1혹은2의_값이_들어와야함() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}