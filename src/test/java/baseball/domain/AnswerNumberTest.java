package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnswerNumberTest {

    @DisplayName("올바른 숫자 리스트를 반환한다.")
    @Test
    void getNumber() {
        // given
        List<Integer> numberList = List.of(1,2,3);
        AnswerNumber answerNumber = new AnswerNumber(numberList);

        // when
        List<Integer> answerNumberList = answerNumber.getNumber();

        // then
        Assertions.assertThat(answerNumberList).containsExactlyInAnyOrderElementsOf(numberList);
    }

    @DisplayName("생성자로 올바르지 않은 숫자가 들어올 경우 예외가 발생한다.")
    @Test
    void answerNumber() {
        // given
        List<Integer> numberList = List.of(0,1,2);

        // when, then
        assertThatThrownBy(() -> new AnswerNumber(numberList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}