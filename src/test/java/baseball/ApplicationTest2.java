package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest2 extends NsTest {
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
    void 숫자사이공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자열_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 재시작_예외_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("135", "12"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Test
    void 재시작_outOfRange_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("135", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }
    @Test
    void 재시작_숫자아님_예외_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("135", "a"))
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
