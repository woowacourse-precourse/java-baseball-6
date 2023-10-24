package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class AnswerGeneratorTest {

    AnswerGenerator answerGenerator = new AnswerGenerator();

    @Test
    void 정답이_3자리인지_확인() {
        // given & when
        List<Integer> answer = answerGenerator.generate();

        // then
        assertThat(answer.size()).isEqualTo(3);
    }

    @Test
    void 정답_숫자들의_범위가_1과_9사이인지_확인() {
        // given & when
        List<Integer> answer = answerGenerator.generate();

        // then
        assertThat(answer.stream().allMatch(ans -> ans > 0 && ans < 10)).isTrue();
    }

    @Test
    void 정답_숫자_중복_확인() {
        // given & when
        List<Integer> answer = answerGenerator.generate();

        // then
        int distinctSize = new HashSet<>(answer).size();
        assertThat(answer.size()).isEqualTo(distinctSize);
    }

}