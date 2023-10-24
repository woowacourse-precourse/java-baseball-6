package baseball.domain.baseballplayer.dto;

import baseball.domain.baseballplayer.dto.Ball;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @Test
    void 데이터_수정_시_UnsupportedOperationException_발생_테스트() {
        // given
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Ball ball = new Ball(list);

        // when
        List<Integer> numbers = ball.numbers();

        // then
        assertThatThrownBy(() -> numbers.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 볼_생성_테스트() {
        // given
        List<Integer> list = List.of(1, 2, 3);
        Ball ball = new Ball(list);
        // when & then
        assertThat(list).isEqualTo(ball.numbers());
    }

    @Test
    void 볼_동등성_테스트() {
        // given
        Ball ball1 = new Ball(List.of(1, 2, 3));
        Ball ball2 = new Ball(List.of(1, 2, 3));
        Ball ball3 = new Ball(List.of(4, 5, 6));
        // when & then
        assertThat(ball1).isEqualTo(ball2);
        assertThat(ball2).isNotEqualTo(ball3);
    }

}