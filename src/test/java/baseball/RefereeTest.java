package baseball;

import baseball.domain.Numbers;
import baseball.domain.Referee;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefereeTest {
    @Test
    void 심판은_스트라이크_개수를_셀_수_있다() {
        List<Integer> randomNumbers = List.of(3, 2, 7);
        List<Integer> inputNumbers = List.of(1, 2, 3);
        Numbers playerNumbers = new Numbers(inputNumbers);
        Numbers answerNumbers = new Numbers(randomNumbers);

        Referee referee = new Referee(answerNumbers);
        Assertions.assertThat(referee.countStrike(playerNumbers)).isEqualTo(1);
    }

    @Test
    void 심판은_볼_개수를_셀_수_있다() {
        List<Integer> randomNumbers = List.of(1, 2, 4);
        List<Integer> inputNumbers = List.of(1, 2, 4);
        Numbers playerNumbers = new Numbers(inputNumbers);
        Numbers answerNumbers = new Numbers(randomNumbers);

        Referee referee = new Referee(answerNumbers);
        Assertions.assertThat(referee.countBall(playerNumbers)).isEqualTo(0);
    }
}
