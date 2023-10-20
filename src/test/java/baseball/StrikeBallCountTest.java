package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StrikeBallCountTest {
    StrikeBallCount strikeBallCount = new StrikeBallCount();

    @Test
    void 스트라이크_볼_갯수_초기화_테스트() {
        strikeBallCount.settingStrikeBallCount();
        Assertions.assertThat(0).isEqualTo(strikeBallCount.getStrike());
        Assertions.assertThat(0).isEqualTo(strikeBallCount.getBall());
    }

    @Test
    void 스트라이크_갯수_증가_테스트() {
        strikeBallCount.settingStrikeBallCount();
        strikeBallCount.plusStringCount();
        Assertions.assertThat(1).isEqualTo(strikeBallCount.getStrike());
    }

    @Test
    void 볼_갯수_증가_테스트() {
        strikeBallCount.settingStrikeBallCount();
        strikeBallCount.plusBallCount();
        Assertions.assertThat(1).isEqualTo(strikeBallCount.getBall());
    }
}