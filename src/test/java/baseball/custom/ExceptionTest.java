package baseball.custom;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest extends NsTest {

    @Test
    void 게임종료후입력_예외처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "125"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
