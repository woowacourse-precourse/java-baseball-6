package baseball.repository;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.AnswerNumbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("정답 숫자 저장소 클래스의 객체에")
class AnswerNumbersRepositoryTest {

    private final AnswerNumbersRepository answerNumbersRepository = new AnswerNumbersRepository();

    @Test
    @DisplayName("정답 숫자 저장후 조회 요청시 null이 아닌 값이 조회되는가")
    void saveAndFindAnswerNumbers() {
        // given
        answerNumbersRepository.saveAnswerNumbers(new AnswerNumbers(List.of(1, 2, 3)));

        // when
        final AnswerNumbers answerNumbers = answerNumbersRepository.findAnswerNumbers();

        // then
        assertThat(answerNumbers).isNotNull();
    }
}
