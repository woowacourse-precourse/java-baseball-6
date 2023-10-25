package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import service.ResultService;

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
    void 중복된_숫자_입력시_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("113"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_이외의_문자_입력시_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 볼_스트라이크_개수_세기() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("153", "132", "123", "236", "351", "531", "246", "135", "2");
                    assertThat(output()).contains("2볼 1스트라이크", "2스트라이크", "1볼 1스트라이크", "1스트라이크", "3볼", "2볼 1스트라이크", "낫싱",
                            "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
