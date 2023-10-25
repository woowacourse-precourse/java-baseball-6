package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_포맷_예외_테스트_일부분_영문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_포맷_예외_테스트_전체_영문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_중복_예외_테스트() {
        assertSimpleTest(
                () ->
                        assertThatThrownBy(() -> runException("112"))
                                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임종료_후_재시작_입력값_숫자_범위_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Test
    void 게임종료_후_재시작_입력값_포맷_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "a"))
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
