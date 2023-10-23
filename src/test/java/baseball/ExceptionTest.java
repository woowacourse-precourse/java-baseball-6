package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("예외 테스트")
class ExceptionTest extends NsTest {

    @Test
    void 다른_개수의_값을_입력한다() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("9102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 올바르지_않은_범위를_입력한다() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("001"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("910"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_값을_입력한다() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("9a2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("9cc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("9ㅁ9"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_값을_입력한다() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("919"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
