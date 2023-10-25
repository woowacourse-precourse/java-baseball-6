package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputExceptionTest extends NsTest {
    @Test
    void 플레이어_숫자_입력_예외_테스트_숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1f3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 플레이어_숫자_입력_예외_테스트_세_자리_수가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 플레이어_숫자_입력_예외_테스트_0이_포함되는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("890"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 플레이어_숫자_입력_예외_테스트_서로_다른_수가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 새_게임_여부_입력_예외_테스트_숫자가_아닌_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", "1f3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 새_게임_여부_입력_예외_테스트_1이나_2가_아닌_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", "333"))
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
