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
    void 스트라이크_볼_낫싱_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("167", "137", "617", "517", "513", "678", "537", "153", "135", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크",
                            "1볼", "2볼", "3볼", "낫싱", "1볼 1스트라이크", "2볼 1스트라이크",
                            "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ab"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "12"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "b"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", ""))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
