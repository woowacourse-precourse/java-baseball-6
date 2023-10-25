package baseball.domain;

import baseball.domain.numbers.AnswerNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerNumberGeneratorTest {
    private final AnswerNumberGenerator answerNumberGenerator = new AnswerNumberGenerator();

    @Test
    @DisplayName("정답 번호를 생성할 때 사이즈가 3개면 성공한다.")
    void 정답번호_사이즈_3개() {
        //given
        List<Integer> numbers = answerNumberGenerator.generate(3);
        //when,then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("정답 번호를 Set으로 변환했을 때 중복없이 그대로 사이즈가 3이면 성공한다.")
    void 정답번호_중복_없음() {
        //given
        List<Integer> numbers = answerNumberGenerator.generate(3);
        //when
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        assertThat(distinctNumbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성된 정답 번호가 1 ~ 9 사이 자연수만 존재하면 성공한다.")
    void 유효한_정답번호_정상() {
        //given
        List<Integer> numbers = answerNumberGenerator.generate(3);
        //when
        boolean match = numbers.stream()
                .allMatch(e -> e.toString().matches("[0-9]"));

        assertThat(match).isTrue();
    }
}