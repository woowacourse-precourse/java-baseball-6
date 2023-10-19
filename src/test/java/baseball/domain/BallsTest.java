package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BallsTest {
    @Test
    void 중복숫자_테스트() {
        List<Integer> input = List.of(1, 1, 1);
        assertThatThrownBy(() -> Balls.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_3보다_크면_예외() {
        List<Integer> input = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> Balls.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 힌트_계산_테스트_3스트라이크() {
        Balls firstBalls = Balls.from(List.of(1, 2, 3));
        Balls secondBalls = Balls.from(List.of(1, 2, 3));
        assertEquals(firstBalls.compare(secondBalls), "3스트라이크");
    }
}
