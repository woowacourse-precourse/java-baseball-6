package baseball.unitTest;

import static org.assertj.core.api.Assertions.*;

import baseball.model.umpire.Umpire;
import baseball.model.vo.BaseballNumber;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Umpire] 심판 테스트")
public class UmpireTest {

    @Nested
    @DisplayName("[new] 생성자 테스트")
    class CreateTest {

        @Test
        @DisplayName("[SUCCESS] 성공적으로 심판을 생성한다")
        void should_success_when_createUmpire() {
            assertThat(Umpire.create()).isInstanceOf(Umpire.class);
        }
    }

    @Nested
    @DisplayName("[utility] 유틸 메서드 테스트")
    class UtilityTest {

        private Umpire umpire;

        @BeforeEach
        void setUp() {
            this.umpire = Umpire.create();
        }

        static Stream<Arguments> provideBaseballNumber() {
            return Stream.of(
                    Arguments.of("낫싱", BaseballNumber.of("123"), BaseballNumber.of("456"), 0, 0),
                    Arguments.of("3볼", BaseballNumber.of("123"), BaseballNumber.of("312"), 0, 3),
                    Arguments.of("1볼 2스트라이크", BaseballNumber.of("123"), BaseballNumber.of("321"), 1, 2),
                    Arguments.of("3스트라이크", BaseballNumber.of("123"), BaseballNumber.of("123"), 3, 0)
            );
        }

        @ParameterizedTest(name = "{index}: {0}")
        @MethodSource("provideBaseballNumber")
        @DisplayName("[SUCCESS] 스트라이크 및 볼 판단 테스트")
        void should_success_when_determineStrikeAndBallCount(String message, BaseballNumber pitcher, BaseballNumber hitter, Integer strike, Integer ball) {
            umpire.determineStrikeAndBall(pitcher, hitter);

            assertThat(umpire.getStrike()).isEqualTo(strike);
            assertThat(umpire.getBall()).isEqualTo(ball);
        }

        @Test
        @DisplayName("[SUCCESS] 3스트라이크일 경우 true를 반환한다")
        void should_true_is3Strike() {
            BaseballNumber baseballNumber = BaseballNumber.of("123");

            umpire.determineStrikeAndBall(baseballNumber, baseballNumber);

            assertThat(umpire.isStrikeOut()).isTrue();
        }
    }
}
