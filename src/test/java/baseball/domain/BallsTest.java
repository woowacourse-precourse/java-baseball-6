package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallsTest {
    @DisplayName("Balls 생성")
    @Nested
    class CreateBalls {
        @DisplayName("유효한 세자리 숫자로 Balls를 생성한다")
        @ParameterizedTest
        @MethodSource
        void SuccessCreateBallsIfValid3DigitNumber(List<Integer> Valid3DigitNumber) {
            List<Ball> expected = Valid3DigitNumber.stream().map(Ball::new).collect(Collectors.toList());

            Balls balls = new Balls(Valid3DigitNumber);

            assertThat(balls.getBalls()).isEqualTo(expected);
        }

        static Stream<Arguments> SuccessCreateBallsIfValid3DigitNumber() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3)),
                    Arguments.of(List.of(7, 8, 9)),
                    Arguments.of(List.of(1, 1, 1))
            );
        }

        @DisplayName("유효하지 않은 세 자리 숫자를 입력하면 예외가 발생한다")
        @Test
        void ThrowExceptionIfInvalid3DigitNumber() {
            List<Integer> invalid3DigitNumber = List.of(1, 2, 0);

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Balls(invalid3DigitNumber));
        }

        @DisplayName("세 자리가 아닌 숫자를 입력하면 예외가 발생한다")
        @ParameterizedTest
        @MethodSource
        void ThrowExceptionIfNot3DigitNumber(List<Integer> not3DigitNumber) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Balls(not3DigitNumber));
        }

        static Stream<Arguments> ThrowExceptionIfNot3DigitNumber() {
            return Stream.of(
                    Arguments.of(List.of(1)),
                    Arguments.of(List.of(1, 2)),
                    Arguments.of(List.of(1, 2, 3, 4))
            );
        }
    }

    @DisplayName("Balls 를 받아 볼 개수를 판단할 수 있다")
    @ParameterizedTest
    @MethodSource
    void JudgeBallCountIfPresentBalls(List<Integer> computerNumber, List<Integer> playerNumber, int expected) {
        Balls computer = new Balls(computerNumber);
        Balls player = new Balls(playerNumber);

        int actual = computer.getBallCount(player);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> JudgeBallCountIfPresentBalls() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6), 0),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 0),
                Arguments.of(List.of(1, 2, 3), List.of(1, 1, 1), 2),
                Arguments.of(List.of(1, 2, 3), List.of(2, 3, 1), 3)
        );
    }

    @DisplayName("Balls 를 받아 스트라이크 개수를 판단할 수 있다")
    @ParameterizedTest
    @MethodSource
    void JudgeStrikeCountIfPresentBalls(List<Integer> computerNumber, List<Integer> playerNumber, int expected) {
        Balls computer = new Balls(computerNumber);
        Balls player = new Balls(playerNumber);

        int actual = computer.getStrikeCount(player);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> JudgeStrikeCountIfPresentBalls() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6), 0),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.of(List.of(1, 2, 3), List.of(1, 1, 1), 1),
                Arguments.of(List.of(1, 2, 3), List.of(2, 3, 1), 0)
        );
    }
}
