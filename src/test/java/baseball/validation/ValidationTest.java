package baseball.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ValidationTest extends NsTest {

    @Test
    void 입력값_문자_예외_테스트() {
        assertThatThrownBy(() -> runException("1a3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_범위_예외_테스트() {
        assertThatThrownBy(() -> runException("109"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_길이_예외_테스트() {
        assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_중복_예외_테스트() {
        assertThatThrownBy(() -> runException("737"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
