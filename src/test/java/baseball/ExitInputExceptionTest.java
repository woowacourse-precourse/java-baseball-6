package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ExitInputExceptionTest extends NsTest {
    @Test
    void 게임_종료_예외_숫자_입력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", "0"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5);
    }

    @Test
    void 게임_종료_예외_공백_입력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", "1 "))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5);
    }

    @Test
    void 게임_종료_예외_문자_입력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", ","))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5);
    }

    @Test
    void 게임_종료_예외_길이_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", "12"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
