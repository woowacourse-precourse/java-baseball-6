package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.BallCount;
import baseball.model.BaseBallNumber;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallCountTest {

    BaseBallNumber computerNumber;

    @BeforeEach
    void setup() {
        computerNumber = BaseBallNumber.generateNumber("123");
    }

    @ParameterizedTest
    @MethodSource("baseBallNumberStream")
    @DisplayName("사용자 입력이 들어왔을 때, 제대로 BallCount를 계산하여 생성하는지 확인")
    void generateBallCount_ReceivedInput_Success(String input, int expectedStrike, int expectedBall) {
        // given
        BaseBallNumber baseBallNumber2 = BaseBallNumber.generateNumber(input);

        // when
        BallCount ballCount = BallCount.generateBallCount(computerNumber, baseBallNumber2);

        // then
        assertThat(ballCount.getStrike()).isEqualTo(expectedStrike);
        assertThat(ballCount.getBall()).isEqualTo(expectedBall);
    }

    static Stream<Arguments> baseBallNumberStream() {
        return Stream.of(
                Arguments.of("234", 0, 2),
                Arguments.of("123", 3, 0),
                Arguments.of("456", 0, 0),
                Arguments.of("789", 0, 0),
                Arguments.of("781", 0, 1),
                Arguments.of("923", 2, 0),
                Arguments.of("321", 1, 2),
                Arguments.of("312", 0, 3)
        );
    }


}
