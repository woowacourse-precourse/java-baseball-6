package baseball.domain.util.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.entity.ScoreBoard;
import java.util.List;
import org.junit.jupiter.api.Test;

class BallAndStrikeCalculatorTest {
    @Test
    void calculate_전부_스트라이크() {
        List<Integer> attempt = List.of(1, 2, 3);
        List<Integer> target = List.of(1, 2, 3);

        ScoreBoard scoreBoard = BallAndStrikeCalculator.calculate(attempt, target);

        assertThat(scoreBoard.getBall()).isEqualTo(0);
        assertThat(scoreBoard.getStrike()).isEqualTo(3);
    }

    @Test
    void calculate_낫싱() {
        List<Integer> attempt = List.of(4, 5, 6);
        List<Integer> target = List.of(1, 2, 3);

        ScoreBoard scoreBoard = BallAndStrikeCalculator.calculate(attempt, target);

        assertThat(scoreBoard.getBall()).isEqualTo(0);
        assertThat(scoreBoard.getStrike()).isEqualTo(0);
    }

    @Test
    void calculate_전부_볼() {
        List<Integer> attempt = List.of(3, 1, 2);
        List<Integer> target = List.of(1, 2, 3);

        ScoreBoard scoreBoard = BallAndStrikeCalculator.calculate(attempt, target);

        assertThat(scoreBoard.getBall()).isEqualTo(3);
        assertThat(scoreBoard.getStrike()).isEqualTo(0);
    }

    @Test
    void calculate_1볼_1스트라이크() {
        List<Integer> attempt = List.of(1, 3, 5);
        List<Integer> target = List.of(1, 2, 3);

        ScoreBoard scoreBoard = BallAndStrikeCalculator.calculate(attempt, target);

        assertThat(scoreBoard.getBall()).isEqualTo(1);
        assertThat(scoreBoard.getStrike()).isEqualTo(1);
    }
}