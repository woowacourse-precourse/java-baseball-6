package baseball.domain;

import static baseball.domain.BaseballResult.ALL_STRIKE;
import static baseball.domain.BaseballResult.BALL;
import static baseball.domain.BaseballResult.BALL_STRIKE;
import static baseball.domain.BaseballResult.NOTHING;
import static baseball.domain.BaseballResult.STRIKE;
import static baseball.utils.ErrorMessages.NOT_MATCH_BASEBALL_RESULT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("BaseballResult Enum")
public class BaseballResultTest {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class of_메서드는 {

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 조건에_맞는_결과값이_존재한다면 {

            private static Stream<Arguments> provideBallAndStrikeCnt() {
                return Stream.of(
                        Arguments.of(1, 1, BALL_STRIKE),
                        Arguments.of(3, 0, BALL),
                        Arguments.of(0, 3, ALL_STRIKE),
                        Arguments.of(0, 2, STRIKE),
                        Arguments.of(0, 0, NOTHING)
                );
            }

            @ParameterizedTest
            @MethodSource("provideBallAndStrikeCnt")
            void Baseball_결과_상태값을_반환한다(int ball, int strike, BaseballResult expect) {
                Baseball baseball = new Baseball(ball, strike);
                Assertions.assertEquals(BaseballResult.of(baseball), expect);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 조건에_맞는_결과값이_존재하지_않는다면 {

            @Test
            void IllegalArgumentException_예외를_던진다() {
                Baseball baseball = new Baseball(-1, 0);
                assertThatThrownBy(() -> BaseballResult.of(baseball))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NOT_MATCH_BASEBALL_RESULT);
            }
        }
    }
}
