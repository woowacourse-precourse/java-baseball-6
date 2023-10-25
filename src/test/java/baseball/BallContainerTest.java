package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallContainerTest {
    static BallContainer ballContainer;

    @BeforeAll
    static void setUp() {
        ballContainer = BallContainer.getFromNumbers(List.of(5, 6, 2));
    }

    @DisplayName("숫자 리스트를 List<Ball>로 정확하게 매핑하는지 확인합니다.")
    @Test
    void getFromNumbers_MakeCorrectBallList() {
        List<Ball> expected = List.of(
                new Ball(5, 0),
                new Ball(6, 1),
                new Ball(2, 2));

        assertThat(ballContainer.getBalls()).isEqualTo(expected);
    }

    @DisplayName("모든 가능한 경우에 대해 정확한 결과를 리턴하는지 확인합니다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentProvider")
    void pitch_forAllCase_isReturnCorrectResult(
            String testName,
            List<Integer> numberList,
            int strikeCount,
            int ballCount
    ) {
        BallContainer otherContainer = BallContainer.getFromNumbers(numberList);

        PitchResult expected = new PitchResult(strikeCount, ballCount);
        PitchResult actual = ballContainer.pitch(otherContainer);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                arguments("3스트라이크", List.of(5, 6, 2), 3, 0),
                arguments("2스트라이크", List.of(5, 6, 7), 2, 0),
                arguments("1스트라이크", List.of(5, 1, 9), 1, 0),
                arguments("2볼 1스트라이크", List.of(6, 5, 2), 1, 2),
                arguments("1볼 1스트라이크", List.of(2, 6, 1), 1, 1),
                arguments("2볼", List.of(2, 5, 8), 0, 2),
                arguments("1볼", List.of(1, 5, 8), 0, 1),
                arguments("낫싱", List.of(1, 3, 9), 0, 0)
        );
    }
}