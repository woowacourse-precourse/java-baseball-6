package baseball.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ScoreTest extends NsTest {

    @Test
    void 스코어_생성_성공() {
        assertSimpleTest(() -> {
            Score score = new Score(1, 2);
            assertThat(score.getStrike()).isEqualTo(2);
            assertThat(score.getBall()).isEqualTo(1);
        });
    }

    @Test
    void 삼_스트라이크() {
        assertSimpleTest(() -> {
            Score score = new Score(0, 3);
            assertThat(score.isThreeStrikes()).isTrue();
        });
    }

    @Override
    protected void runMain() {
    }
}
