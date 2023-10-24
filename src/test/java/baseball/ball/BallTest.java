package baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {

    @ParameterizedTest
    @DisplayName("공 하나 비교하기")
    @CsvSource({
            "3,2,3,2,STRIKE",
            "3,1,3,2,BALL",
            "3,1,5,2,NOTHING"
    })
    void testCompareBall(int firstNumber, int firstIndex, int secondNumber, int secondIndex, Result expectedResult) {
        Number number1 = new Number(firstNumber);
        Index index1 = new Index(firstIndex);
        Ball ball1 = new Ball(number1, index1);

        Number number2 = new Number(secondNumber);
        Index index2 = new Index(secondIndex);
        Ball ball2 = new Ball(number2, index2);

        Result result = ball1.compareWithOtherBall(ball2);

        assertThat(result).isEqualTo(expectedResult);
    }
}
