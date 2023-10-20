package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}