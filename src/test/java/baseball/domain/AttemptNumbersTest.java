package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constant.ResultStatus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("시도 숫자 도메인 클래스의 객체에")
class AttemptNumbersTest {

    @Nested
    @DisplayName("유저의 시도 결과 확인 요청시")
    class CheckAnswer {

        @Test
        @DisplayName("정답인 경우 (3스트라이크, 0볼, SUCCESS)로 계산되는가")
        void success() {
            // given
            final AnswerNumbers answerNumbers = new AnswerNumbers(List.of(1, 2, 3));
            final AttemptNumbers attemptNumbers = new AttemptNumbers(List.of(1, 2, 3));

            // when
            final BallCount ballCount = attemptNumbers.checkAnswer(answerNumbers);

            // then
            assertThat(ballCount.checkResultStatus()).isEqualTo(ResultStatus.SUCCESS);
            assertThat(ballCount.countStrike()).isEqualTo(3);
            assertThat(ballCount.countBall()).isZero();
        }

        @Test
        @DisplayName("모두 틀렸을 경우 (0스트라이크, 0볼, CONTINUE)로 계산되는가")
        void allMiss() {
            // given
            final AnswerNumbers answerNumbers = new AnswerNumbers(List.of(1, 2, 3));
            final AttemptNumbers attemptNumbers = new AttemptNumbers(List.of(4, 5, 6));

            // when
            final BallCount ballCount = attemptNumbers.checkAnswer(answerNumbers);

            // then
            assertThat(ballCount.checkResultStatus()).isEqualTo(ResultStatus.CONTINUE);
            assertThat(ballCount.countStrike()).isZero();
            assertThat(ballCount.countBall()).isZero();
        }

        @Test
        @DisplayName("0스트라이크 3볼인 경우 (0스트라이크, 3볼, CONTINUE)로 계산되는가")
        void twoStrikeOneBall() {
            // given
            final AnswerNumbers answerNumbers = new AnswerNumbers(List.of(1, 2, 3));
            final AttemptNumbers attemptNumbers = new AttemptNumbers(List.of(3, 1, 2));

            // when
            final BallCount ballCount = attemptNumbers.checkAnswer(answerNumbers);

            // then
            assertThat(ballCount.checkResultStatus()).isEqualTo(ResultStatus.CONTINUE);
            assertThat(ballCount.countStrike()).isZero();
            assertThat(ballCount.countBall()).isEqualTo(3);
        }

        @Test
        @DisplayName("1스트라이크 2볼인 경우 (1스트라이크, 2볼, CONTINUE)로 계산되는가")
        void oneStrikeTwoBall() {
            // given
            final AnswerNumbers answerNumbers = new AnswerNumbers(List.of(1, 2, 3));
            final AttemptNumbers attemptNumbers = new AttemptNumbers(List.of(1, 3, 2));

            // when
            final BallCount ballCount = attemptNumbers.checkAnswer(answerNumbers);

            // then
            assertThat(ballCount.checkResultStatus()).isEqualTo(ResultStatus.CONTINUE);
            assertThat(ballCount.countStrike()).isOne();
            assertThat(ballCount.countBall()).isEqualTo(2);
        }
    }
}
