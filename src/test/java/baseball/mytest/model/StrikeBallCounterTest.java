package baseball.mytest.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StrikeBallCounterTest {
    StrikeBallCounter strikeBallCounter = new StrikeBallCounter();


    @Test
    void 볼_개수가_일치하면_true_검증() {
        String playerInput = "135";
        String computerNumber = "153";
        StrikeBallCounter.CompareResult result = strikeBallCounter.compare(playerInput, computerNumber);

        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void 스트라이크_개수가_일치하면_true_검증() {
        String playerInput = "135";
        String computerNumber = "136";
        StrikeBallCounter.CompareResult result = strikeBallCounter.compare(playerInput, computerNumber);

        assertThat(result.getStrike()).isEqualTo(2);
    }

    @Test
    void 스트라이크_볼_개수가_일치하면_true_검증() {
        String playerinput = "135";
        String computerNumber = "153";

        StrikeBallCounter.CompareResult result = strikeBallCounter.compare(playerinput, computerNumber);

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void 스트라이크와_볼이_0개이면_true_검증() {
        String playerInput = "135";
        String computerNumber = "246";
        StrikeBallCounter.CompareResult result = strikeBallCounter.compare(playerInput, computerNumber);

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);

    }
}
