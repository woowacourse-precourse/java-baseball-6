package baseball.Controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CheckAnswerTest {

    CheckAnswer checkAnswer = new CheckAnswer();

    @Test
    void 정답비교_3볼() {
        List<Integer> playerNumber = Arrays.asList(1, 2, 3);
        List<Integer> computerNumber = Arrays.asList(2, 3, 1);
        String hintMsg = "3볼 ";

        String k = checkAnswer.compareNumber(playerNumber, computerNumber);
        assertThat(k).isEqualTo(hintMsg);

    }


}