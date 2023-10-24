package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.locales.GameScripts;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
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
    void 게임_낫싱_볼_스트라이크_전체_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "532", "541", "513", "135", "2");
                    assertThat(output()).contains("낫싱", "1볼 1스트라이크", "2볼", "3볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }


    @Test
    void 예외_테스트_잘못된_범위_초과_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_잘못된_0_포함_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("203"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_잘못된_0으로_시작_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("013"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_잘못된_0으로_끝나는_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("890"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_잘못된_중복되는_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("223"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
