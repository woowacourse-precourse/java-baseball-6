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
    void 예외_테스트_유효하지않은_입력값_중복된_자리수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_유효하지않은_입력값_숫자가아닌값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-0a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_유효하지않은_입력값_Null() {
        assertRandomNumberInRangeTest(() ->
                {
                    assertThatThrownBy(() -> run("246", null))
                            .isInstanceOf(IllegalArgumentException.class);
                    assertThat(output()).contains("낫싱");
                },
                1, 3, 5
        );
    }

    @Test
    void 예외_테스트_유효하지않은_종료값_다른값() {
        assertRandomNumberInRangeTest(() ->
                {
                    assertThatThrownBy(() -> run("327", "135", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                    assertThat(output()).contains("1볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 예외_테스트_유효하지않은_종료값_반복된_유효키() {
        assertRandomNumberInRangeTest(() ->
                {
                    assertThatThrownBy(() -> run("246", "135", "11"))
                            .isInstanceOf(IllegalArgumentException.class);
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 예외_테스트_유효하지않은_종료값_Null() {
        assertRandomNumberInRangeTest(() ->
                {
                    assertThatThrownBy(() -> run("327", "135", null))
                            .isInstanceOf(IllegalArgumentException.class);
                    assertThat(output()).contains("1볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
