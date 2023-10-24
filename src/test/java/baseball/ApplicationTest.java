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
    void 게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("234", "457", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "1볼", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                5, 8, 9
        );
    }

    @Test
    void 게임_재시작_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            assertThatThrownBy(() -> run("589", "3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 입력값입니다.");
        }, 5, 8, 9);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 입력입니다. 자릿수 오류")
        );
    }
    @Test
    void 예외_테스트_숫자길이() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 입력입니다. 자릿수 오류")
        );
    }

    @Test
    void 예외_테스트_숫자범위() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("098"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 입력입니다. 범위 오류")
        );
    }

    @Test
    void 예외_테스트_중복값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("222"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 예외_테스트_숫자가아닌경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
