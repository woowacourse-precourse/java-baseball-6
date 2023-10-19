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
}
