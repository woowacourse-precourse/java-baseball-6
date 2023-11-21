package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 게임한판_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 낫싱_후_3볼_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "789", "231", "123", "1", "145", "362", "897", "789", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "3볼", "3스트라이크", "낫싱", "낫싱", "3볼", "3스트라이크", "게임 종료");
                },
                1, 2, 3, 7, 8, 9
        );
    }

    @Test
    void 예외_세자리가_아닐때_테스트() {
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains("세자리여야");
        });
    }

    @Test
    void 예외_숫자가_아닐때_테스트() {
        assertSimpleTest(() -> {
            runException("45@");
            assertThat(output()).contains("숫자");
        });
    }

    @Test
    void 예외_같은수가_있을때_테스트() {
        assertSimpleTest(() -> {
            runException("122");
            assertThat(output()).contains("서로 다른 수");
        });
    }

    @Test
    void 예외_범위가_맞지_않을때_테스트() {
        assertSimpleTest(() -> {
            runException("102");
            assertThat(output()).contains("1~9사이");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
