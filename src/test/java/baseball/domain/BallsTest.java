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
}
