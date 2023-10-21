package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseBallsTest {

    @Test
    void baseBall_3s() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));
        assertThat(baseBalls.compare(Arrays.asList(1, 2, 3)).stream().filter(s -> s.equals(BallScore.STRIKE)).count()).isEqualTo(3);
    }
    @Test
    void baseBall_3b() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));
        assertThat(baseBalls.compare(Arrays.asList(3, 1, 2)).stream().filter(s -> s.equals(BallScore.BALL)).count()).isEqualTo(3);
    }
    @Test
    void baseBall_1b_1s() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));
        List<BallScore> compare = baseBalls.compare(Arrays.asList(1, 3, 5));
        assertThat(compare.stream().filter(s -> s.equals(BallScore.STRIKE)).count()).isEqualTo(1);
        assertThat(compare.stream().filter(s -> s.equals(BallScore.BALL)).count()).isEqualTo(1);
    }

}
