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
    void 입력_4자리이상_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자1부터9확인_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("101"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자확인_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("asd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 긴문자열_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("21oen21nkn2edqwdqw0dqwh09hwq0dhwqdhwq0diqwcoqshcasnckjasnkcasasnkcsanckaskcnajsnkasnckasjjkn3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 엔터입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
