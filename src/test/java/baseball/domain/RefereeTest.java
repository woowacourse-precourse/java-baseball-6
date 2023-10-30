package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setReferee() {
        referee = new Referee();
    }

    @Test
    void 스트라이크3() {
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void 낫싱() {
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(4, 6, 8));
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void 볼1() {
        String result = referee.compare(Arrays.asList(2, 1, 3), Arrays.asList(1, 4, 5));
        assertThat(result).isEqualTo("1볼");
    }

    @Test
    void 볼1_스트라이크1() {
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(2, 5, 3));
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 볼3() {
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1));
        assertThat(result).isEqualTo("3볼");
    }


}