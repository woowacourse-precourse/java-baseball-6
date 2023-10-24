package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest extends NsTest {
    @Test
    void 재시작_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() ->
                assertThatThrownBy(() -> runException("123", "0"))
                        .isInstanceOf(IllegalArgumentException.class),
                1,2,3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
