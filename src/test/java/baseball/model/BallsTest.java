package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallsTest {

    @ParameterizedTest
    @CsvSource(value = {"0:1:true", "0:2:false", "1:2:true"}, delimiter = ':')
    void 스트라이크_판별(int index, int number, boolean expected) {
        Balls computer = new Balls("123");
        Ball ball = new Ball(index, number);

        assertThat(computer.isStrike(ball)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "0:1:false", "1:3:true"}, delimiter = ':')
    void 볼_판별(int index, int number, boolean expected) {
        Balls computer = new Balls("123");
        Ball ball = new Ball(index, number);

        assertThat(computer.isBall(ball)).isEqualTo(expected);
    }

}
