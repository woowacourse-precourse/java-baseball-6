package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest extends NsTest {
    @Test
    void 게임종료_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("389", "198", "386", "486", "2");
                    assertThat(output()).contains("1스트라이크", "1볼", "2스트라이크", "3스트라이크", "게임 종료");
                },
                4, 8, 6
        );
    }

    @Test
    void 예외_테스트_숫자가_아닌_값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자가_아닌_값_마이너스() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-34"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복된_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0이_포함된_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
