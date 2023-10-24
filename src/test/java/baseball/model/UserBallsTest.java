package baseball.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class UserBallsTest extends NsTest {

    @Test
    void 예외_길이_초과() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new UserBalls("1234"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_길이_미달() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new UserBalls("12"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_중복() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new UserBalls("112"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_숫자_아님() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new UserBalls("1A2"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_숫자_범위_초과() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new UserBalls("032"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 유저_볼_생성_성공() {
        assertSimpleTest(() -> new UserBalls("123"));
        assertSimpleTest(() -> new UserBalls("456"));
        assertSimpleTest(() -> new UserBalls("789"));
    }


    @Override
    protected void runMain() {
    }
}
