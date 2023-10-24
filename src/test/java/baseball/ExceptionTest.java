package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest extends NsTest {

    @Test
    void 문자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("우테코"))
                        .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("numbers cannot be out of range")
        );
    }

    @Test
    void 범위_외_숫자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("902"))
                        .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("numbers cannot be out of range")
        );
    }

    @Test
    void 중복_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("numbers cannot be duplicated")
        );
    }

    @Test
    void 종료_재시작_선택지에_없는_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "3");
                    },
                    1, 3, 5
            );
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Input is incorrect");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
