package baseball.domain;

import static baseball.domain.Result.ALL_STRIKE;
import static baseball.domain.Result.BALL;
import static baseball.domain.Result.BALL_STRIKE;
import static baseball.domain.Result.NOTHING;
import static baseball.domain.Result.STRIKE;
import static baseball.utils.ErrorMessages.NOT_MATCH_BASEBALL_RESULT;

import baseball.config.JudgmentTestConfig.TestJudgment;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Result Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ResultTest {

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
    void of_메서드는_조건에_맞는_결과값이_존재한다면_Result를_반환한다(int ball, int strike, Result expect) {
        Judgment judgment = new TestJudgment(ball, strike);
        Assertions.assertEquals(Result.of(judgment), expect);
    }

    @Test
    void of_메서드는_조건에_맞는_결과값이_존재하지_않으면_예외를_던진다() {
        Judgment judgment = new TestJudgment(-1, 0);
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> Result.of(judgment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_MATCH_BASEBALL_RESULT);
    }
}
