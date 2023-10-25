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
    void 예외_테스트_숫자_유효성_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값중 1~9 숫자가 아닌 값이 존재 합니다.")
        );
    }

    @Test
    void 예외_테스트_입력값_공백문자_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값중 1~9 숫자가 아닌 값이 존재 합니다.")
        );
    }

    @Test
    void 예외_테스트_숫자_중복_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값은 서로 다른 3개의 숫자여야 합니다.")
        );
    }

    @Test
    void 예외_테스트_입력값_공백문자만_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값이 공백 문자만 포함하고 있습니다.")
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
