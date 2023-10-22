package baseball.controller.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultMapperTest {

    @ParameterizedTest(name = "{index}: {3}")
    @MethodSource("parameters")
    void 결과를가지고_문자열로_만들어준다(int ballCount, int strikeCount, String expectedMessage, String testMessage) {
        // when
        String result = ResultMapper.resultToString(ballCount, strikeCount);

        // then
        assertThat(result).isEqualTo(expectedMessage);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 1, "1볼 1스트라이크", "1볼 1스트라이크를 반환한다."),
                Arguments.of(0, 0, "낫싱", "0볼 0스트라이크면 낫싱을 반환한다."),
                Arguments.of(0, 1, "1스트라이크", "1스트라이크를 반환한다."),
                Arguments.of(2, 0, "2볼 ", "2볼을 반환한다.")
        );
    }
}
