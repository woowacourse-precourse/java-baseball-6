package baseball.domain.game.result;

import baseball.domain.status.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayResultTest {

    @Test
    @DisplayName("공의 비교 결과를 기록할 수 있다.")
    void record() {
        PlayResult playResult = new PlayResult();

        playResult.record(BallStatus.STRIKE);
        playResult.record(BallStatus.STRIKE);
        playResult.record(BallStatus.NOTHING);
        playResult.record(BallStatus.BALL);

        assertThat(playResult).isEqualTo(new PlayResult(2, 1));
    }
}