package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

import baseball.domain.Result;

class CaculatorTest {

    @Test
    void calcTest() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);

        Result res = Caculator.count(computer, user);

        assertThat(res.getStrike()).isEqualTo(3);
        assertThat(res.getBall()).isEqualTo(0);
    }

    @Test
    void oneBallOneStrikeTest() {
        List<Integer> computer = List.of(1, 4, 2);
        List<Integer> user = List.of(1, 2, 3);

        Result res = Caculator.count(computer, user);

        assertThat(res.getStrike()).isEqualTo(1);
        assertThat(res.getBall()).isEqualTo(1);
    }
}