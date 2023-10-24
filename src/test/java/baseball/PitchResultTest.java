package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PitchResultTest {
    @DisplayName("결과 메시지를 정확하게 리턴하는지 확인합니다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsProvider")
    void getHint_ReturnCorrectMessage(String expectedMessage, int strikeCount, int ballCount) {
        PitchResult pitchResult = new PitchResult(strikeCount, ballCount);

        assertThat(pitchResult.getHint()).isEqualTo(expectedMessage);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments("3스트라이크", 3, 0),
                arguments("2스트라이크", 2, 0),
                arguments("1스트라이크", 1, 0),
                arguments("2볼 1스트라이크", 1, 2),
                arguments("1볼 1스트라이크", 1, 1),
                arguments("2볼", 0, 2),
                arguments("1볼", 0, 1),
                arguments("낫싱", 0, 0)
        );
    }
}