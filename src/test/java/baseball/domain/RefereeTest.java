package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    List<Integer> computer = Arrays.asList(1, 8, 9);
    Referee referee = new Referee(computer);

    @Test
    void 심판_판정_테스트() {
        List<Integer> user = Arrays.asList(5, 2, 8);
        String result = referee.getResult(user);
        assertThat(result).isEqualTo("1볼");

        user = Arrays.asList(1, 4, 8);
        result = referee.getResult(user);
        assertThat(result).isEqualTo("1볼 1스트라이크");

        user = Arrays.asList(2, 3, 4);
        result = referee.getResult(user);
        assertThat(result).isEqualTo("낫싱");

        user = Arrays.asList(1, 8, 9);
        result = referee.getResult(user);
        assertThat(result).isEqualTo("3스트라이크");
    }
}