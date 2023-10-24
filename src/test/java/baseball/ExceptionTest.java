package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends NsTest {

    @Test
    void 공백_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(" "))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복숫자_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("112"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자0은_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("012"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 숫자아닌값_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("string"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
