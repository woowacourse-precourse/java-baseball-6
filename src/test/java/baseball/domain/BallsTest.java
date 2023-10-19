package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
