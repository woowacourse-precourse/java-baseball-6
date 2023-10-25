package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static baseball.domain.BaseballFlag.*;
import static org.assertj.core.api.Assertions.*;

class BaseballResultTest {

    @Test
    @DisplayName("BALL은 2개 STRIKE는 1개 NOTHING은 0개가 저장되어야 한다.")
    void gameResult() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.translate(List.of(BALL, STRIKE, BALL));

        assertThat(baseballResult.getTransResult()).isEqualTo(Map.of(
                BALL, 2,
                STRIKE, 1,
                NOTHING, 0
        ));
    }
}