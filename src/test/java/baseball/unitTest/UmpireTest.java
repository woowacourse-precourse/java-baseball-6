package baseball.unitTest;

import baseball.model.umpire.Umpire;
import baseball.model.vo.BaseballNumber;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("심판 테스트")
public class UmpireTest {

    @Nested
    @DisplayName("[new] 생성자 테스트")
    class CreateTest {

        @Test
        @DisplayName("[SUCCESS] 성공적으로 심판을 생성한다")
        void should_success_when_createUmpire() {
            Assertions.assertThat(Umpire.create())
                    .isInstanceOf(Umpire.class);
        }
    }

    @Nested
    class UtilityTest {

        private Umpire umpire;

        @BeforeEach
        void setUp() {
            this.umpire = Umpire.create();
        }

        static Stream<Arguments> provideBaseballNumber() {
            return Stream.of(
                    Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(0, 0)),
                    Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), Arrays.asList(3, 0))
            );
        }

        @ParameterizedTest
        @MethodSource("provideBaseballNumber")
        @DisplayName("[SUCCESS] pitcher와 hitter의 수를 토대로 스트라이크 및 볼 갯수를 반환한다")
        void should_success_when_determineStrikeAndBallCount(List<Integer> pitcher, List<Integer> hitter, List<Integer> result) {
            BaseballNumber pitcherNumber = BaseballNumber.of(pitcher);
            BaseballNumber hitterNumber = BaseballNumber.of(hitter);

            umpire.determineStrikeAndBall(pitcherNumber, hitterNumber);

            Assertions.assertThat(umpire.getStrikeAndBall())
                    .isEqualTo(result);
        }
    }
}
