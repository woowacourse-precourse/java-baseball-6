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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains("재입력");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
