package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    @DisplayName("정답 야구공과 사용자가 입력한 야구공을 비교해 겹치는 부분이 있는지 확인한다.")
    void hasRelationWith() {
        // given
        Ball answerBall = new Ball(List.of(1, 2, 3));
        Ball tryBall = new Ball(List.of(1, 5, 6));

        // when
        boolean result = answerBall.hasNoRelationWith(tryBall);

        // then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("정답 야구공과 사용자가 입력한 야구공을 비교해 겹치는 부분이 없는지 확인한다.")
    void hasNoRelationWith() {
        // given
        Ball answerBall = new Ball(List.of(1, 2, 3));
        Ball tryBall = new Ball(List.of(4, 5, 6));

        // when
        boolean result = answerBall.hasNoRelationWith(tryBall);

        // then
        assertThat(result).isEqualTo(true);
    }
}