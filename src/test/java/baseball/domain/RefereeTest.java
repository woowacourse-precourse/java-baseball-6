package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RefereeTest { // alt+insert

    private static final List<Integer> ANSWER = Arrays.asList(1,2,3);
    private Referee referee;

    @BeforeEach
    void setup() {
        referee = new Referee();
    }
    @Test
    void 스트라이크3() {
//        Referee referee = new Referee();
        String result = referee.compare(Arrays.asList(1,2,3), Arrays.asList(1,2,3));
//        System.out.println(result);
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void 아웃() {
//        Referee referee = new Referee();
        String result = referee.compare(Arrays.asList(1,2,3), Arrays.asList(7,8,9));
        assertThat(result).isEqualTo("낫싱");
    }
}