package baseball.domain;

import baseball.domain.vo.JudgeResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class BaseballJudgeTest {
    @DisplayName("BaseballJudge는 두 숫자를 받아서 스트라이크, 볼의 개수를 계산하여 반환한다")
    @ParameterizedTest
    @CsvSource(value = {
            "123, 123, 3, 0",
            "928, 123, 1, 0",
            "156, 123, 1, 0",
            "134, 123, 1, 1",
            "321, 123, 1, 2",
            "312, 123, 0, 3",
            "456, 123, 0, 0",
    })
    void number_check_test(String input, String answer, int strike, int ball) {
        // given
        BaseballJudge baseballJudge = new BaseballJudge(answer);

        // when
        JudgeResult result = baseballJudge.judge(input);

        // then
        assertSoftly(softly -> {
            softly.assertThat(result.strike()).isEqualTo(strike);
            softly.assertThat(result.ball()).isEqualTo(ball);
        });
    }
}
