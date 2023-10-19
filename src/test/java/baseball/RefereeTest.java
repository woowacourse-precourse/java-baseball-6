package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    @Test
    public void 같은_수가_다른_자리에_있으면_볼이다() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> number = List.of(2, 4, 5);

        int result = Referee.countBall(computer, number);

        assertThat(result).isEqualTo(1);
    }
}