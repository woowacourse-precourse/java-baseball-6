package baseball;

import baseball.domain.ScoreCalculator;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreCalculatorTest {
    @Test
    @DisplayName("아무것도 안맞는 경우 낫싱")
    void 모두다름_낫싱(){
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 5, 6);

        ScoreCalculator calculator = getScoreCalculator(randomNumbers, playerNumbers);
        Assertions.assertThat(calculator.getNothing()).isEqualTo(1);
    }
    @Test
    @DisplayName("다른 자리에 같은 숫자가 2개 있는 경우 2볼")
    void 다른자리_같은숫자2개_2볼(){
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 1, 2);

        ScoreCalculator calculator = getScoreCalculator(randomNumbers, playerNumbers);
        Assertions.assertThat(calculator.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 자리 같은 숫자 1개와 다른자리 같은 숫자 1개 있는 경우 1볼 1스트라이크")
    void 일볼_일스트라이크(){
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 2, 1);

        ScoreCalculator calculator = getScoreCalculator(randomNumbers, playerNumbers);
        Assertions.assertThat(calculator.getBall()).isEqualTo(1);
        Assertions.assertThat(calculator.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 자리 같은 숫자 3개 있는 경우 3스트라이크")
    void 삼스트라이크(){
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);

        ScoreCalculator calculator = getScoreCalculator(randomNumbers, playerNumbers);
        Assertions.assertThat(calculator.getStrike()).isEqualTo(3);
    }

    private static ScoreCalculator getScoreCalculator(List<Integer> randomNumbers,
            List<Integer> playerNumbers) {
        ScoreCalculator calculator = new ScoreCalculator();
        calculator.calculate(randomNumbers, playerNumbers);
        return calculator;
    }

}
