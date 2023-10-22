package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultTest {

    Result result = new Result();
    @Test
    void calcTest() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user1 = List.of(1, 2, 3);
        List<Integer> user2 = List.of(1, 4, 2);

        result.calc(computer, user1);

        Assertions.assertThat(result.getStrike()).isEqualTo(3);

        result.init();
        result.calc(computer, user2);

        Assertions.assertThat(result.getStrike()).isEqualTo(1);
        Assertions.assertThat(result.getBall()).isEqualTo(1);
    }
}