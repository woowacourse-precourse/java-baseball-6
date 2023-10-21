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

class BaseballsTest {
    @DisplayName("Balls 생성")
    @Nested
    class CreateBaseballs {
        @DisplayName("유효한 세자리 숫자로 Balls를 생성한다")
        @ParameterizedTest
        @MethodSource
        void successCreateBallsIfValid3DigitNumber(List<Integer> Valid3DigitNumber) {
            List<Ball> expected = Valid3DigitNumber.stream().map(Ball::new).collect(Collectors.toList());

            Baseballs baseballs = new Baseballs(Valid3DigitNumber);

            assertThat(baseballs.getBalls()).isEqualTo(expected);
        }

        static Stream<Arguments> successCreateBallsIfValid3DigitNumber() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3)),
                    Arguments.of(List.of(7, 8, 9)),
                    Arguments.of(List.of(1, 1, 1))
            );
        }

        @DisplayName("유효하지 않은 세 자리 숫자를 입력하면 예외가 발생한다")
        @Test
        void throwExceptionIfInvalid3DigitNumber() {
            List<Integer> invalid3DigitNumber = List.of(1, 2, 0);

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Baseballs(invalid3DigitNumber));
        }

        @DisplayName("세 자리가 아닌 숫자를 입력하면 예외가 발생한다")
        @ParameterizedTest
        @MethodSource
        void throwExceptionIfNot3DigitNumber(List<Integer> not3DigitNumber) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Baseballs(not3DigitNumber));
        }

        static Stream<Arguments> throwExceptionIfNot3DigitNumber() {
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
    void judgeBallCountIfPresentBalls(List<Integer> computerNumber, List<Integer> playerNumber, int expected) {
        Baseballs computer = new Baseballs(computerNumber);
        Baseballs player = new Baseballs(playerNumber);

        int actual = computer.getBallCount(player);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> judgeBallCountIfPresentBalls() {
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
    void judgeStrikeCountIfPresentBalls(List<Integer> computerNumber, List<Integer> playerNumber, int expected) {
        Baseballs computer = new Baseballs(computerNumber);
        Baseballs player = new Baseballs(playerNumber);

        int actual = computer.getStrikeCount(player);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> judgeStrikeCountIfPresentBalls() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6), 0),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.of(List.of(1, 2, 3), List.of(1, 1, 1), 1),
                Arguments.of(List.of(1, 2, 3), List.of(2, 3, 1), 0)
        );
    }
}
