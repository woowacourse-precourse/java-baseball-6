package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_길이3미만() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_동일한숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0을포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("d12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_commandNumberException() {
        final IllegalCheck illegalcheck = new IllegalCheck();

        assertThatThrownBy(() -> illegalcheck.commandAvailable("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 1 or 2 입니다.");
    }

    @Test
    void 예외_테스트_commandNumberException_문자() {
        final IllegalCheck illegalcheck = new IllegalCheck();

        assertThatThrownBy(() -> illegalcheck.commandAvailable("c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 1 or 2 입니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
