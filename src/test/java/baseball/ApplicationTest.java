package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationTest extends NsTest {

    @Test
    @Order(1)
    void 예외_테스트_길이() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @Order(2)
    void 예외_테스트_숫자가아닌입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(".qw"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @Order(3)
    void 예외_테스트_0인숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("105"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @Order(4)
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
