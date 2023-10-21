package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultBaseballAlgorithmTest {

    @DisplayName("유저가 입력한 숫자와 컴퓨터가 생성한 숫자를 바탕으로 숫자야구 결과를 계산한다.")
    @Test
    void calculateBaseballResult() {
        //given
        BaseballAlgorithm baseballAlgorithm = new DefaultBaseballAlgorithm();

        List<Integer> randomNumber = List.of(2, 6, 4);

        String userInputA = "247";
        String userInputB = "264";
        String userInputC = "357";

        //when
        String result1 = baseballAlgorithm.calculateBaseballResult(randomNumber, userInputA);
        String result2 = baseballAlgorithm.calculateBaseballResult(randomNumber, userInputB);
        String result3 = baseballAlgorithm.calculateBaseballResult(randomNumber, userInputC);

        //then
        assertThat(result1).isEqualTo("1볼 1스트라이크");
        assertThat(result2).isEqualTo("3스트라이크");
        assertThat(result3).isEqualTo("낫싱");
    }

}
