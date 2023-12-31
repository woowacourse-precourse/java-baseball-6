package baseball.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void 야구공_크기_유효성_검사_테스트() {
        List<Integer> digits = List.of(1, 2, 3, 4);

        Assertions.assertThatThrownBy(() -> new Ball(digits))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 야구공_중복_숫자_유효성_검사_테스트() {
        List<Integer> digits = List.of(1, 3, 3);

        Assertions.assertThatThrownBy(() -> new Ball(digits))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크_확인_테스트() {
        Ball answer = new Ball(List.of(1, 2, 3));
        Ball player = new Ball(List.of(1, 3, 4));

        Assertions.assertThat(answer.checkStrike(player))
                .isEqualTo(1);
    }

    @Test
    void 볼_확인_테스트() {
        Ball answer = new Ball(List.of(1, 2, 3));
        Ball player = new Ball(List.of(1, 3, 4));

        Assertions.assertThat(answer.checkBall(player))
                .isEqualTo(1);
    }
}
