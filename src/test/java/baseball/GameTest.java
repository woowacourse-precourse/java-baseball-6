package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest extends NsTest {

    @Test
    public void 사용자입력_예외_테스트_1() {
        /* 사용자 입력이 세자리 수보다 작은 경우 */
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("14"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    public void 사용자입력_예외_테스트_2() {
        /* 사용자 입력이 세자리 수보다 큰 경우 */
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1334"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    public void 사용자입력_예외_테스트_3() {
        /* 사용자 입력이 숫자로만 이루어지지 않은 경우 */
        /* 첫 번째가 문자 */
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("w12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        /* 두 번째가 문자 */
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1w2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        /* 세 번째가 문자 */
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12w"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 사용자입력_예외_테스트_4() {
        /* 사용자 입력이 세자리 수보다 큰 경우 */
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1334"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 게임재시작_입력_예외_테스트_1() {
        /* 문자를 입력한 경우 */
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "234", "345", "w"))
                            .isInstanceOf(IllegalArgumentException.class);
                    assertThat(output()).contains("1볼", "2볼", "3스트라이크", "게임 종료");
                },
                3,4,5
        );
    }

    @Test
    public void 게임재시작_입력_예외_테스트_2() {
        /* 1과 2가 아닌 다른 숫자를 입력한 경우 */
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "234", "345", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                    assertThat(output()).contains("1볼", "2볼", "3스트라이크", "게임 종료");
                },
                3,4,5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
