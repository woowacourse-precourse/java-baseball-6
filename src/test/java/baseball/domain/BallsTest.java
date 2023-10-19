package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BallsTest {
    @DisplayName("Balls 생성")
    @Nested
    class CreateBalls {
        @DisplayName("유효한 세자리 숫자로 Balls를 생성한다")
        @ParameterizedTest
        @CsvSource({"123, 1, 2, 3", "789, 7, 8, 9", "111, 1, 1, 1"})
        void SuccessCreateBallsIfValid3DigitNumber(int valid3DigitNumber, int first, int second, int third) {
            List<Ball> expected = List.of(new Ball(first), new Ball(second), new Ball(third));

            Balls balls = new Balls(valid3DigitNumber);

            assertThat(balls.getBalls()).isEqualTo(expected);
        }

        @DisplayName("유효하지 않은 세 자리 숫자를 입력하면 예외가 발생한다")
        @Test
        void ThrowExceptionIfInvalid3DigitNumber() {
            int invalid3DigitNumber = 120;

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Balls(invalid3DigitNumber));
        }

        @DisplayName("세 자리가 아닌 숫자를 입력하면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(ints = {1, 12, 1234})
        void ThrowExceptionIfNot3DigitNumber(int not3DigitNumber) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Balls(not3DigitNumber));
        }
    }

    @DisplayName("Balls 를 받아 볼 개수를 판단할 수 있다")
    @ParameterizedTest
    @CsvSource({"123, 456, 0", "123, 123, 0", "123, 111, 2", "123, 231, 3"})
    void JudgeBallCountIfPresentBalls(int computerNumber, int playerNumber, int expected) {
        Balls computer = new Balls(computerNumber);
        Balls player = new Balls(playerNumber);

        int actual = computer.getBallCount(player);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Balls 를 받아 스트라이크 개수를 판단할 수 있다")
    @ParameterizedTest
    @CsvSource({"123, 456, 0", "123, 123, 3", "123, 111, 1", "123, 231, 0"})
    void JudgeStrikeCountIfPresentBalls(int computerNumber, int playerNumber, int expected) {
        Balls computer = new Balls(computerNumber);
        Balls player = new Balls(playerNumber);

        int actual = computer.getStrikeCount(player);

        assertThat(actual).isEqualTo(expected);
    }
}
