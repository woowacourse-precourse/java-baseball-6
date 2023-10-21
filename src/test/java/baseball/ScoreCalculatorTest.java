package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorTest {

    @Test
    void 스트라이크_출력_확인() {

        List<Integer>  randomNumbers = List.of (1, 2, 3);
        List<Integer> strike0 = List.of (4, 5, 6);
        List<Integer> strike1 = List.of (1, 4, 5);
        List<Integer> strike2 = List.of (1, 2, 5);
        List<Integer> strike3 = List.of (1, 2, 3);

        ScoreCalculator scoreCalculator = new ScoreCalculator();

        Assertions.assertThat(scoreCalculator.computeStrike(randomNumbers, strike0)).isEqualTo(0);
        Assertions.assertThat(scoreCalculator.computeStrike(randomNumbers, strike1)).isEqualTo(1);
        Assertions.assertThat(scoreCalculator.computeStrike(randomNumbers, strike2)).isEqualTo(2);
        Assertions.assertThat(scoreCalculator.computeStrike(randomNumbers, strike3)).isEqualTo(3);

    }

    @Test
    void 볼_출력_확인() {

        List<Integer>  randomNumbers = List.of (1, 2, 3);
        List<Integer> ball0 = List.of (4, 5, 6);
        List<Integer> ball1 = List.of (4, 5, 1);
        List<Integer> ball2 = List.of (4, 1, 2);
        List<Integer> ball3 = List.of (3, 1, 2);

        ScoreCalculator scoreCalculator = new ScoreCalculator();

        Assertions.assertThat(scoreCalculator.computeBall(randomNumbers, ball0, 0)).isEqualTo(0);
        Assertions.assertThat(scoreCalculator.computeBall(randomNumbers, ball1, 0)).isEqualTo(1);
        Assertions.assertThat(scoreCalculator.computeBall(randomNumbers, ball2, 0)).isEqualTo(2);
        Assertions.assertThat(scoreCalculator.computeBall(randomNumbers, ball3, 0)).isEqualTo(3);


    }

}