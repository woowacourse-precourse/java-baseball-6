package baseball.domain;

import static org.assertj.core.api.Assertions.*;


import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {
    @Test
    void judgeTest() throws Exception {
        //given
        List<Integer> computerNumbers = List.of(1, 9, 2);
        List<Integer> userNumbers = List.of(2, 9, 4);
        int ball = 1;
        int strike = 1;

        //when
        Referee referee = new Referee(computerNumbers, userNumbers);

        //then
        assertThat(referee.getBall()).isEqualTo(1);
        assertThat(referee.getStrike()).isEqualTo(1);
        assertThat(referee.getJudgement()).isEqualTo("1볼 1스트라이크");
    }

}
