package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class NumberInputExceptionTest extends NsTest {
    @Test
    void 길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 영_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12₩"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
