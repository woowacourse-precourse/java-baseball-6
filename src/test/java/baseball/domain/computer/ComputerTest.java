package baseball.domain.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    @RepeatedTest(10)
    @DisplayName("3개의 answerNumbers를 가진 Computer를 생성할 수 있다.")
    void createWithAnswerNumbersByRandomGenerater() {
        // when
        Computer result = Computer.init();
        // then
        assertThat(result).isInstanceOf(Computer.class);
        System.out.println(result.getAnswerNumbers());

    }
}