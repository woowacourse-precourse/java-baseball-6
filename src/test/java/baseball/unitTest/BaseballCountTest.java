package baseball.unitTest;

import static org.assertj.core.api.Assertions.*;

import baseball.model.BaseballCount;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballCountTest {

    private BaseballCount baseballCount;

    public static Stream<Arguments> provideListsForIsSameNumberAndLocation() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(5, 8, 2), Arrays.asList(5, 8, 0)),
                Arguments.of(Arrays.asList(1, 8, 9), Arrays.asList(1, 2, 3))
        );
    }

    public static Stream<Arguments> provideListsForIsSameNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2)),
                Arguments.of(Arrays.asList(5, 8, 2), Arrays.asList(2, 3, 6)),
                Arguments.of(Arrays.asList(3, 2, 0), Arrays.asList(2, 3, 6))
        );
    }

    @BeforeEach
    void setUp() {
        baseballCount = new BaseballCount();
    }

    @ParameterizedTest
    @MethodSource("provideListsForIsSameNumberAndLocation")
    @DisplayName("사용자와 컴퓨터의 수를 비교하여_수와 위치 모두 같다면_스트라이크를 반환한다")
    void userAndComputer_isSameNumberAndLocation_strike(List<Integer> userNumber, List<Integer> computerNumber) {
        Map<String, Integer> pitched = baseballCount.pitch(userNumber, computerNumber);

        assertThat(pitched.get("ball")).isZero();
        assertThat(pitched.get("strike")).isNotZero();
    }

    @ParameterizedTest
    @MethodSource("provideListsForIsSameNumber")
    @DisplayName("사용자와 컴퓨터의 수를 비교하여_수가 모두 같다면_볼을 반환한다")
    void userAndComputer_isSameNumber_ball(List<Integer> userNumber, List<Integer> computerNumber) {
        Map<String, Integer> pitched = baseballCount.pitch(userNumber, computerNumber);

        assertThat(pitched.get("ball")).isNotZero();
        assertThat(pitched.get("strike")).isZero();
    }

    @Test
    @DisplayName("사용자와 컴퓨터의 수를 비교하여_한개도 맞지 않는다면_낫싱을 반환한다")
    void userAndComputer_isNotAllSame_Nothing() {
        Map<String, Integer> pitched = baseballCount.pitch(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));

        assertThat(pitched.get("ball")).isZero();
        assertThat(pitched.get("strike")).isZero();
    }
}
