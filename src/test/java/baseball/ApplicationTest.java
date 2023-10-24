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
    void length_Over_Exception_Test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void length_under_Exception_Test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void zero_Exception_Test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void duplication_Exception_Test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void charcter_Exception_Test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa1"))

        );
    }
    @Test
    void restart_Exception_UnvalidNum_Test() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("478", "0"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                4,7,8
        );
    }
    @Test
    void restart_Exception_Charcter_Test() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("478", "b"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                4,7,8
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}