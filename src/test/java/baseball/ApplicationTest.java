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
    void 볼() {
        assertRandomNumberInRangeTest(
                () -> {
                    run( "987", "879", "2");
                    assertThat(output()).contains("3볼", "3스트라이크", "게임 종료");
                },
                8, 7, 9
        );
    }

    @Test
    void 두개_볼_스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("315", "351", "2");
                    assertThat(output()).contains("2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                3,5,1
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
