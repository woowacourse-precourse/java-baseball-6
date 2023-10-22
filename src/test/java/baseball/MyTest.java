package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class MyTest extends NsTest {
    @Test
    void 중복_입력값_테스트() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("122")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 숫자가_아닌_입력_테스트() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("일이삼")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 영_테스트() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("012")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 종료후_예외_테스트() {
        assertRandomNumberInRangeTest(() -> assertThatThrownBy(() -> runException("123", "135", "3"))
                .isInstanceOf(IllegalArgumentException.class), 1, 3, 5);
    }

    @Override
    protected void runMain() {
        // TODO Auto-generated method stub
        Application.main(new String[] {});
    }
}
