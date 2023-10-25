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
    void 예외_테스트_길이_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_문자_입력() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("abc"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복_숫자_입력() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("111"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0_입력() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("102"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_재시작_옵션_문자_입력() {
        assertRandomNumberInRangeTest(
            () -> {
                assertThatThrownBy(() -> runException("123", "q"))
                    .isInstanceOf(IllegalArgumentException.class);
            },
            1, 2, 3
        );
    }

    @Test
    void 예외_테스트_재시작_옵션_다른숫자_입력() {
        assertRandomNumberInRangeTest(
            () -> {
                assertThatThrownBy(() -> runException("123", "3"))
                    .isInstanceOf(IllegalArgumentException.class);
            },
            1, 2, 3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
