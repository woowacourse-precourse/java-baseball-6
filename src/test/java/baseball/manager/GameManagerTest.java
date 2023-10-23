package baseball.manager;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameManagerTest  extends NsTest {

    @Test
    void 재시작_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("153", "135", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}