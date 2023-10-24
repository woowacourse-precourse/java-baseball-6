package baseball.utilTest;

import baseball.util.BallStrikeCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallStrikeCalculatorTest {
    @Test
    public void BallStrikeTest(){
        BallStrikeCalculator ballStrikeCalculator = new BallStrikeCalculator();
        String result1 = ballStrikeCalculator.calculateAnswer("123","143");
        Assertions.assertThat(result1).isEqualTo("2스트라이크");

        String result2 = ballStrikeCalculator.calculateAnswer("321", "123");
        Assertions.assertThat(result2).isEqualTo("2볼 1스트라이크");

        String result4 = ballStrikeCalculator.calculateAnswer("123", "456");
        Assertions.assertThat(result4).isEqualTo("낫싱");
    }
}
