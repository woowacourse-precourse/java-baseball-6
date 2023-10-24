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
    void 정답_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output()).contains("3스트라이크", "3개의 숫자를 모두 맞히셨습니다!", "게임 종료", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                },
                1, 2, 3
        );
    }

    @Test
    void 볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("231", "234", "256", "123", "2");
                    assertThat(output()).contains("3볼", "2볼", "1볼");
                },
                1, 2, 3
        );
    }

    @Test
    void 볼_스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("132", "134","123", "2");
                    assertThat(output()).contains("2볼 1스트라이크", "1볼 1스트라이크");
                },
                1, 2, 3
        );
    }

    @Test
    void 인풋_타입_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 인풋_자릿수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 인풋_자릿수_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 인풋_수겹침_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작_인풋_타입_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> runException("123", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                ,1, 2, 3
        );
    }

    @Test
    void 재시작_인풋_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> runException("123", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                ,1, 2, 3
        );

        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> runException("123", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                ,1, 2, 3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
