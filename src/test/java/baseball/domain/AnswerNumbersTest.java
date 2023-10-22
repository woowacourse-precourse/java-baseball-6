package baseball.domain;

import baseball.domain.numbers.AnswerNumberGenerator;
import baseball.domain.numbers.AnswerNumbers;
import baseball.domain.numbers.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerNumbersTest {
    private final AnswerNumbers answerNumbers = AnswerNumbers.createAnswerNumbers(new AnswerNumberGenerator());

    @Test
    @DisplayName("정답 번호가 1,2,3이고 플레이어 번호도 1,2,3이면 true를 반환하면 성공한다.")
    void 플레이어_번호_일치_O() {
        //given
        AnswerNumbers answerNumbers = AnswerNumbers.createAnswerNumbers(new TestGenerator());
        boolean result = answerNumbers.isSameWithAnswer(List.of(1, 2, 3));
        //when
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("정답 번호가 1,2,3이고 플레이어 번호가 4,2,1이면 false를 반환하면 성공한다.")
    void 플레이어_번호_일치_X() {
        //given
        AnswerNumbers answerNumbers = AnswerNumbers.createAnswerNumbers(new TestGenerator());
        boolean result = answerNumbers.isSameWithAnswer(List.of(4, 2, 1));
        //when
        assertThat(result).isFalse();
    }

    private static class TestGenerator implements NumberGenerator {
        @Override
        public List<Integer> generate(int numberSize) {
            return List.of(1, 2, 3);
        }
    }
}