package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BaseBallsTest {

    @Test
    void baseBall_1b_1s() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));
        GameResult compare = baseBalls.compare(Arrays.asList(3, 2, 4));

        assertThat(compare.getResult(BallScore.STRIKE)).isEqualTo(1);
        assertThat(compare.getResult(BallScore.BALL)).isEqualTo(1);
    }
    @Test
    void baseBall_3b() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));
        GameResult compare = baseBalls.compare(Arrays.asList(3, 1, 2));

        assertThat(compare.getResult(BallScore.STRIKE)).isEqualTo(0);
        assertThat(compare.getResult(BallScore.BALL)).isEqualTo(3);
    }
    @Test
    void baseBall_3s() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));
        GameResult compare = baseBalls.compare(Arrays.asList(1, 2, 3));

        assertThat(compare.getResult(BallScore.STRIKE)).isEqualTo(3);
        assertThat(compare.getResult(BallScore.BALL)).isEqualTo(0);
    }

    @Test
    void baseBall_3n() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));
        GameResult compare = baseBalls.compare(Arrays.asList(4, 5, 6));

        assertThat(compare.getResult(BallScore.STRIKE)).isEqualTo(0);
        assertThat(compare.getResult(BallScore.BALL)).isEqualTo(0);
    }

}
