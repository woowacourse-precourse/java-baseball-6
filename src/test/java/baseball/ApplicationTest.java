package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 사용자_숫자_입력_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("+12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_숫자_입력_예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력_더하기_기호_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("+246", "135", "1", "+597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 사용자_입력_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_숫자_입력_범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_숫자_입력_타입_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("String"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_종료_입력_타입_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        run("246", "135", "String");
                    });
                },
                1, 3, 5
        );
    }

    @Test
    void 사용자_종료_입력_범위_외의_숫자_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThrows(IllegalArgumentException.class, () ->
                        run("246", "135", "7")
                    );
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
