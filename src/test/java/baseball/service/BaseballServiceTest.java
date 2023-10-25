package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constant.ResultStatus;
import baseball.domain.AnswerNumbers;
import baseball.domain.AttemptNumbers;
import baseball.domain.BallCount;
import baseball.repository.AnswerNumbersRepository;
import baseball.utils.RandomNumberGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("야구 게임 서비스 클래스의 객체에")
class BaseballServiceTest {

    private final AnswerNumbersRepository answerNumbersRepository = new AnswerNumbersRepository();
    private final BaseballService baseballService =
            new BaseballService(new RandomNumberGenerator(), answerNumbersRepository);

    @Test
    @DisplayName("랜덤 숫자 생성 및 저장 요청시 AnswerNumbers가 저장되는가")
    void saveRandomNumbers() {
        // given
        // when
        baseballService.saveRandomNumbers();

        // then
        final AnswerNumbers answerNumbers = answerNumbersRepository.findAnswerNumbers();
        assertThat(answerNumbers).isNotNull();
    }

    @Nested
    @DisplayName("결과 확인 요청시")
    class CheckAnswer {

        @Test
        @DisplayName("정답인 경우 [3스트라이크, 0볼, SUCCESS]로 계산되는가")
        void success() {
            // given
            answerNumbersRepository.saveAnswerNumbers(new AnswerNumbers(List.of(1, 2, 3)));

            // when
            final BallCount ballCount =
                    baseballService.checkAnswer(new AttemptNumbers(List.of(1, 2, 3)));

            // then
            assertThat(ballCount.countStrike()).isEqualTo(3);
            assertThat(ballCount.countBall()).isZero();
            assertThat(ballCount.checkResultStatus()).isEqualTo(ResultStatus.SUCCESS);
        }

        @Test
        @DisplayName("모두 틀렸을 경우 [0스트라이크, 0볼, CONTINUE]로 계산되는가")
        void noneMatch() {
            // given
            answerNumbersRepository.saveAnswerNumbers(new AnswerNumbers(List.of(1, 2, 3)));

            // when
            final BallCount ballCount =
                    baseballService.checkAnswer(new AttemptNumbers(List.of(4, 5, 6)));

            // then
            assertThat(ballCount.countStrike()).isZero();
            assertThat(ballCount.countBall()).isZero();
            assertThat(ballCount.checkResultStatus()).isEqualTo(ResultStatus.CONTINUE);
        }

        @Test
        @DisplayName("1스트라이크 1볼인 경우 [1스트라이크, 1볼, CONTINUE]로 계산되는가")
        void oneStrikeOneBall() {
            // given
            answerNumbersRepository.saveAnswerNumbers(new AnswerNumbers(List.of(1, 2, 3)));

            // when
            final BallCount ballCount =
                    baseballService.checkAnswer(new AttemptNumbers(List.of(1, 4, 2)));

            // then
            assertThat(ballCount.countStrike()).isOne();
            assertThat(ballCount.countBall()).isOne();
            assertThat(ballCount.checkResultStatus()).isEqualTo(ResultStatus.CONTINUE);
        }

        @Test
        @DisplayName("0스트라이크 2볼인 경우 [0스트라이크, 2볼, CONTINUE]로 계산되는가")
        void twoBall() {
            // given
            answerNumbersRepository.saveAnswerNumbers(new AnswerNumbers(List.of(1, 2, 3)));

            // when
            final BallCount ballCount =
                    baseballService.checkAnswer(new AttemptNumbers(List.of(3, 4, 2)));

            // then
            assertThat(ballCount.countStrike()).isZero();
            assertThat(ballCount.countBall()).isEqualTo(2);
            assertThat(ballCount.checkResultStatus()).isEqualTo(ResultStatus.CONTINUE);
        }
    }
}
