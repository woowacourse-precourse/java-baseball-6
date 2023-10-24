package baseball.ball;

import baseball.game.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    @Test
    @DisplayName("공 3개 비교하기")
    void testCompareBalls() {
        List<Integer> numbers = List.of(1, 5, 6);
        Balls balls = new Balls(numbers);

        List<Integer> otherNumbers = List.of(1, 6, 9);
        Balls otherBalls = new Balls(otherNumbers);

        GameResult gameResult = balls.compareWithBalls(otherBalls);

        int ballSize = gameResult.getBallCount();
        int strikeSize = gameResult.getStrikeCount();

        assertThat(strikeSize).isEqualTo(1);
        assertThat(ballSize).isEqualTo(1);
    }
}
