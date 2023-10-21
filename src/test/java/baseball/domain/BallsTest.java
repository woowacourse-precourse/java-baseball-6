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
}