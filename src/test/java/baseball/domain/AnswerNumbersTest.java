package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constant.StrikeBall;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("정답 숫자 도메인 클래스의 객체에")
class AnswerNumbersTest {

    @Nested
    @DisplayName("스트라이크, 볼, 혹은 못맞춘 경우 판별 요청시")
    class CheckStrikeBall {

        @Test
        @DisplayName("스트라이크인 경우 STRIKE를 반환하는가")
        void strike() {
            // given
            final AnswerNumbers answerNumbers = new AnswerNumbers(List.of(1, 2, 3));

            // when
            final StrikeBall result = answerNumbers.checkStrikeBall(new Number(1), 0);

            // then
            assertThat(result).isEqualTo(StrikeBall.STRIKE);
        }

        @Test
        @DisplayName("볼인 경우 BALL를 반환하는가")
        void ball() {
            // given
            final AnswerNumbers answerNumbers = new AnswerNumbers(List.of(1, 2, 3));

            // when
            final StrikeBall result = answerNumbers.checkStrikeBall(new Number(1), 2);

            // then
            assertThat(result).isEqualTo(StrikeBall.BALL);
        }

        @Test
        @DisplayName("못맞춘 경우 NONE를 반환하는가")
        void none() {
            // given
            final AnswerNumbers answerNumbers = new AnswerNumbers(List.of(1, 2, 3));

            // when
            final StrikeBall result = answerNumbers.checkStrikeBall(new Number(4), 1);

            // then
            assertThat(result).isEqualTo(StrikeBall.NONE);
        }
    }
}
