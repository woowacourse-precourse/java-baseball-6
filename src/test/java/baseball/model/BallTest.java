package baseball.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class BallTest extends NsTest {

    @Test
    void 예외_글자_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Ball('A'))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_범위_초과_작음() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Ball(0))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_범위_초과_큼() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Ball(10))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 예외_범위_초과_마이너스() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Ball(-1))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 공_만들기_성공() {
        assertSimpleTest(() -> new Ball(1));
    }

    @Test
    void 비교_같은_볼() {
        Ball a = new Ball(1);
        Ball b = new Ball(1);
        assertThat(Ball.equals(a, b)).isTrue();
    }

    @Test
    void 비교_다른_볼() {
        Ball a = new Ball(1);
        Ball b = new Ball(2);
        assertThat(Ball.equals(a, b)).isFalse();
    }

    @Override
    protected void runMain() {

    }


}
