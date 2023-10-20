package baseball.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class JudgeResultTest {
    @DisplayName("JudgeResult는 스트라이크와 볼이 모두 0일 때 isNothing이 true를 반환한다.")
    @Test
    void nothing_test() {
        // given
        int strike = 0;
        int ball = 0;

        // when
        JudgeResult judgeResult = new JudgeResult(strike, ball);

        // then
        assertThat(judgeResult.isNothing()).isTrue();
    }

    @DisplayName("JudgeResult는 스트라이크와 볼이 하나라도 0이 아닐 때 isNothing이 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 0", "0, 1", "1, 2"})
    void not_nothing_test(int strike, int ball) {
        // when
        JudgeResult judgeResult = new JudgeResult(strike, ball);

        // then
        assertThat(judgeResult.isNothing()).isFalse();
    }

    @DisplayName("JudgeResult는 스트라이크가 3일 때 isThreeStrike가 true를 반환한다.")
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

    @DisplayName("JudgeResult는 스트라이크가 3이 아닐 때 isThreeStrike가 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 0", "0, 1", "1, 2"})
    void not_three_strike_test(int strike, int ball) {
        // when
        JudgeResult judgeResult = new JudgeResult(strike, ball);

        // then
        assertThat(judgeResult.isThreeStrike()).isFalse();
    }
}