package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BallsTest {

    static Stream<Arguments> createBallsData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(5, 2, 4)),
                Arguments.of(Arrays.asList(3, 9, 7))
        );
    }

    static Stream<Arguments> createBallsExceptionData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(5, 2, 4)),
                Arguments.of(Arrays.asList(3, 9, 7))
        );
    }

    @DisplayName("balls 생성 시 null 값이 아닌지 테스트.")
    @ParameterizedTest
    @MethodSource("createBallsData")
    void balls_생성_테스트(List<Integer> values) {
        Balls balls = new Balls(values);
        assertNotNull(balls);
    }

    @DisplayName("balls 생성 예외 테스트")
    @ParameterizedTest
    @MethodSource("createBallsExceptionData")
    void balls_생성_예외_테스트(List<Integer> values) {
        assertThrows(IllegalArgumentException.class, () -> new Balls(values));
    }


    @DisplayName("Balls끼리 가지고 있는 Ball중에서 같은 숫자,같은 위치의 개수를 구한다.")
    @ParameterizedTest
    @MethodSource("createBallsWithSameNumberAndSamePositionData")
    void 같은숫자_같은위치_개수(List<Integer> numbers, List<Integer> otherNumbers, int expected) {
        Balls balls = new Balls(numbers);
        Balls otherBalls = new Balls(otherNumbers);
        assertThat(balls.getSamePositionAndSameNumberCount(otherBalls)).isEqualTo(expected);
    }

    private static Stream<Arguments> createBallsWithSameNumberAndSamePositionData() {
        return Stream.of(
                Arguments.of(List.of(2, 5, 9), List.of(1, 2, 3), 0),
                Arguments.of(List.of(1, 5, 9), List.of(1, 2, 3), 1),
                Arguments.of(List.of(1, 2, 9), List.of(1, 2, 3), 2),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3)
        );
    }

    @DisplayName("Balls끼리 가지고 있는 Ball중에서 같은 숫자,다른 위치의 개수를 구한다.")
    @ParameterizedTest
    @MethodSource("createBallsWithSameNumberAndOtherPositionData")
    void 같은숫자_다른위치_개수(List<Integer> numbers, List<Integer> otherNumbers, int expected) {
        Balls balls = new Balls(numbers);
        Balls otherBalls = new Balls(otherNumbers);
        assertThat(balls.getOtherPositionAndSameNumberCount(otherBalls)).isEqualTo(expected);
    }

    private static Stream<Arguments> createBallsWithSameNumberAndOtherPositionData() {
        return Stream.of(
                Arguments.of(List.of(4, 5, 9), List.of(1, 2, 3), 0),
                Arguments.of(List.of(5, 1, 9), List.of(1, 2, 3), 1),
                Arguments.of(List.of(9, 1, 2), List.of(1, 2, 3), 2),
                Arguments.of(List.of(3, 1, 2), List.of(1, 2, 3), 3)
        );
    }


}