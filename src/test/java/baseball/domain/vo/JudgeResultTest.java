package baseball.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class JudgeResultTest {
    @Nested
    @DisplayName("JudgeResult의 isThreeStrike는")
    class IsThreeStrikeTest {
        @DisplayName("스트라이크가 3일 때 true를 반환한다.")
        @Test
        void three_strike_test() {
            // given
            int strike = 3;
            int ball = 0;

            // when
            JudgeResult judgeResult = new JudgeResult(strike, ball);

            // then
            assertThat(judgeResult.isThreeStrike()).isTrue();
        }

        @DisplayName("스트라이크가 3이 아닐 때 false를 반환한다.")
        @ParameterizedTest
        @CsvSource(value = {"1, 0", "0, 1", "1, 2"})
        void not_three_strike_test(int strike, int ball) {
            // when
            JudgeResult judgeResult = new JudgeResult(strike, ball);

            // then
            assertThat(judgeResult.isThreeStrike()).isFalse();
        }
    }

    @Nested
    @DisplayName("JudgeResult의 toString은")
    class ToStringTest {
        @DisplayName("스트라이크와 볼의 개수를 볼-스트라이크 순서로 반환한다")
        @ParameterizedTest
        @CsvSource(value = {
                "1, 0, 1스트라이크",
                "0, 1, 1볼",
                "1, 2, 2볼 1스트라이크",
                "3, 0, 3스트라이크"
        })
        void toString_test(int strike, int ball, String expected) {
            // when
            JudgeResult judgeResult = new JudgeResult(strike, ball);

            // then
            assertThat(judgeResult).hasToString(expected);
        }

        @DisplayName("스트라이크와 볼이 모두 0일 때 '낫싱'을 반환한다.")
        @Test
        void nothing_toString_test() {
            // given
            int strike = 0;
            int ball = 0;

            // when
            JudgeResult judgeResult = new JudgeResult(strike, ball);

            // then
            assertThat(judgeResult).hasToString("낫싱");
        }
    }
}