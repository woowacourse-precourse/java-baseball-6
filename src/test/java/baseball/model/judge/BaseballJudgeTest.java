package baseball.model.judge;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Ball;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballJudgeTest {

    @DisplayName("자리와 숫자가 모두 일치하면 3스트라이크이다.")
    @Test
    void numberAllMatch() {
        // given
        Ball computerBall = new Ball(List.of(1, 2, 3));
        BaseballJudge judge = new BaseballJudge(computerBall);

        Ball playerBall = new Ball(List.of(1, 2, 3));

        // when
        JudgeResult judgeResult = judge.judge(playerBall);

        // then
        assertThat(judgeResult).extracting("ballCount")
                .extracting("count")
                .isEqualTo(0);
        assertThat(judgeResult).extracting("strikeCount")
                .extracting("count")
                .isEqualTo(3);
        assertThat(judgeResult).extracting("isNothing")
                .isEqualTo(false);
    }

    @DisplayName("자리와 숫자가 모두 불일치하면 낫싱이다.")
    @Test
    void numberNoneMatch() {
        // given
        Ball computerBall = new Ball(List.of(1, 2, 3));
        BaseballJudge judge = new BaseballJudge(computerBall);

        Ball playerBall = new Ball(List.of(4, 5, 6));

        // when
        JudgeResult judgeResult = judge.judge(playerBall);

        // then
        assertThat(judgeResult).extracting("ballCount")
                .extracting("count")
                .isEqualTo(0);
        assertThat(judgeResult).extracting("strikeCount")
                .extracting("count")
                .isEqualTo(0);
        assertThat(judgeResult).extracting("isNothing")
                .isEqualTo(true);
    }

    @DisplayName("1개만 자리와 숫자 모두 일치하고 2개는 숫자만 일치할 경우 2볼 1스트라이크이다.")
    @Test
    void oneBallTwoStrike() {
        // given
        Ball computerBall = new Ball(List.of(1, 2, 3));
        BaseballJudge judge = new BaseballJudge(computerBall);

        Ball playerBall = new Ball(List.of(1, 3, 2));

        // when
        JudgeResult judgeResult = judge.judge(playerBall);

        // then
        assertThat(judgeResult).extracting("ballCount")
                .extracting("count")
                .isEqualTo(2);
        assertThat(judgeResult).extracting("strikeCount")
                .extracting("count")
                .isEqualTo(1);
        assertThat(judgeResult).extracting("isNothing")
                .isEqualTo(false);
    }

    @DisplayName("3개의 숫자가 숫자만 일치할 경우 3볼이다.")
    @Test
    void threeBall() {
        // given
        Ball computerBall = new Ball(List.of(1, 2, 3));
        BaseballJudge judge = new BaseballJudge(computerBall);

        Ball playerBall = new Ball(List.of(3, 1, 2));

        // when
        JudgeResult judgeResult = judge.judge(playerBall);

        // then
        assertThat(judgeResult).extracting("ballCount")
                .extracting("count")
                .isEqualTo(3);
        assertThat(judgeResult).extracting("strikeCount")
                .extracting("count")
                .isEqualTo(0);
        assertThat(judgeResult).extracting("isNothing")
                .isEqualTo(false);
    }

}