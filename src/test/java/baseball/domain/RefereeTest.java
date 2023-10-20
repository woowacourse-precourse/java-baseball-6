package baseball.domain;

import static org.assertj.core.api.Assertions.*;


import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {
    @Test
    void judgeTest() {
        //given
        List<Integer> computerNumbers = List.of(1, 9, 2);
        List<Integer> userNumbers = List.of(2, 9, 4);

        //when
        Referee referee = new Referee();
        //then
        assertThat(referee.getBall()).isEqualTo(1);
        assertThat(referee.getStrike()).isEqualTo(1);
    }

}
