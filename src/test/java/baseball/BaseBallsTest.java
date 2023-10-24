package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BallScore;
import baseball.domain.BaseBalls;
import baseball.domain.CompareNumber;
import baseball.domain.DataTypeChanger;
import baseball.domain.GameResult;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallsTest {
    private BaseBalls baseBalls;
    @BeforeEach
    void beforeEach() {
        baseBalls = new BaseBalls(DataTypeChanger.compareNumberFormat(Arrays.asList(1, 2, 3)));
    }

    @Test
    void baseBall_1b_1s() {
        List<CompareNumber> userBalls = DataTypeChanger.compareNumberFormat(Arrays.asList(3, 2, 4));
        GameResult compare = baseBalls.compare(userBalls);

        assertThat(compare.getResult(BallScore.STRIKE)).isEqualTo(1);
        assertThat(compare.getResult(BallScore.BALL)).isEqualTo(1);
    }
    @Test
    void baseBall_3b() {
        List<CompareNumber> userBalls = DataTypeChanger.compareNumberFormat(Arrays.asList(3, 1, 2));
        GameResult compare = baseBalls.compare(userBalls);

        assertThat(compare.getResult(BallScore.STRIKE)).isEqualTo(0);
        assertThat(compare.getResult(BallScore.BALL)).isEqualTo(3);
    }
    @Test
    void baseBall_3s() {
        List<CompareNumber> userBalls = DataTypeChanger.compareNumberFormat(Arrays.asList(1, 2, 3));
        GameResult compare = baseBalls.compare(userBalls);

        assertThat(compare.getResult(BallScore.STRIKE)).isEqualTo(3);
        assertThat(compare.getResult(BallScore.BALL)).isEqualTo(0);
    }

    @Test
    void baseBall_3n() {
        List<CompareNumber> userBalls = DataTypeChanger.compareNumberFormat(Arrays.asList(4, 5, 6));
        GameResult compare = baseBalls.compare(userBalls);

        assertThat(compare.getResult(BallScore.STRIKE)).isEqualTo(0);
        assertThat(compare.getResult(BallScore.BALL)).isEqualTo(0);
    }

}
