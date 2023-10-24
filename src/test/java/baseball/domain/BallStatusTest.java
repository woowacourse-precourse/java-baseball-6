package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallStatusTest {

    @DisplayName("value와 index의 일치 여부에 따라 BallStatus를 반환한다")
    @ParameterizedTest
    @MethodSource("ofArgumentsProvider")
    void of(boolean valueMatches, boolean indexMatches, BallStatus expectedBallStatus) {
        assertThat(BallStatus.of(valueMatches, indexMatches)).isEqualTo(expectedBallStatus);
    }

    static Stream<Arguments> ofArgumentsProvider() {
        return Stream.of(
                Arguments.of(true, true, BallStatus.STRIKE),
                Arguments.of(true, false, BallStatus.BALL),
                Arguments.of(false, true, BallStatus.VALUE_NOT_MATCHED),
                Arguments.of(false, false, BallStatus.NOTHING_MATCHED)
        );
    }
}
