package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest extends NsTest {
    @Test
    void 숫자_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("15"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작_예외_처리1() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", ""))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 재시작_예외_처리2() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "z"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 재시작_예외_처리3() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "0"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 재시작_예외_처리4() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "11"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
