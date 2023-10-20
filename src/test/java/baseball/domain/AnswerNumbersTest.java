package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerNumbersTest {
    private final AnswerNumbers answerNumbers = AnswerNumbers.createAnswerNumbers(new AnswerNumberGenerator());

    @Test
    @DisplayName("생성된 정답 번호의 크기가 3이면 성공한다.")
    void 정답번호_크기_정상() {
        //given, when
        List<Integer> numbers = answerNumbers.getAnswerNumbers();
        //then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성된 정답 번호에 중복된 번호없이 크기가 3이라면 성공한다.")
    void 정답번호_중복_없음() {
        //given
        List<Integer> numbers = answerNumbers.getAnswerNumbers();
        //when
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        assertThat(distinctNumbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성된 정답 번호가 1 ~ 9 사이 자연수만 존재하면 성공한다.")
    void 유효한_정답번호_정상() {
        //given
        List<Integer> numbers = answerNumbers.getAnswerNumbers();
        //when
        boolean match = numbers.stream()
                .allMatch(e -> e.toString().matches("[0-9]"));

        assertThat(match).isTrue();
    }


}