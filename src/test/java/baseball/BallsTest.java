package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void ballsSizeTest() {
        List<Ball> ballList = List.of(new Ball(1), new Ball(2));
        Balls balls = new Balls(ballList);
        assertThatThrownBy(() -> balls.validateSize(ballList))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("3자리의 숫자를 입력해주세요.");
    }

    @Test
    void ballHasDuplicates() {
        List<Ball> ballList = List.of(new Ball(1), new Ball(1), new Ball(2));
        Balls balls = new Balls(ballList);
        assertThatThrownBy(() -> balls.valdateDuplicates(ballList))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되지 않는 3자리의 숫자를 입력해주세요.");

    }
}
