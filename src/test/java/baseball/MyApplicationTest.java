package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyApplicationTest extends NsTest {

    @Test
    @DisplayName("사용자 입력이 숫자가 아닌 경우")
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("사용자 입력이 공백인 경우")
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("사용자 입력이 3자리 숫자가 아닌 경우")
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("사용자 입력에 중복된 숫자가 있는 경우")
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임 종료 후 옵션 입력이 숫자가 아닌 경우")
    void 예외_테스트5() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("135", "a"))
                        .isInstanceOf(IllegalArgumentException.class),
                1, 3, 5
        );
    }

    @Test
    @DisplayName("게임 종료 후 옵션 입력이 공백인 경우")
    void 예외_테스트6() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("135", " "))
                        .isInstanceOf(IllegalArgumentException.class),
                1, 3, 5
        );
    }

    @Test
    @DisplayName("게임 종료 후 옵션 입력이 유효하지 않은 경우")
    void 예외_테스트7() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("135", "3"))
                        .isInstanceOf(IllegalArgumentException.class),
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
