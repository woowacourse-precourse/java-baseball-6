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
    void 모두_스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output()).containsAnyOf("3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 모두_볼() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "321", "2");
                    assertThat(output()).containsAnyOf("3볼", "3스트라이크", "게임 종료");
                },
                3, 2, 1
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
