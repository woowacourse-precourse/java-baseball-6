package baseball.game.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TurnStatusTest {

    @Test
    void PLAYING인_상태에서_isPlaying_호출시_true() {
        Assertions.assertThat(TurnStatus.PLAYING.isPlaying()).isTrue();
    }

    @Test
    void TURNOVER인_상태에서_isPlaying_호출시_false() {
        Assertions.assertThat(TurnStatus.TURNOVER.isPlaying()).isFalse();
    }

}