package baseball.model;


import baseball.model.baseball.Strike;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StrikeTest {

    Strike strike = new Strike(1);

    @Test
    @DisplayName("스트라이크의 개수가 0인지 확인한다.")
    void check_no_count(){
        //given
        strike.updateStrikeCount(0);

        //when
        boolean isNoCountStrike = strike.isNoCountStrike();

        //then
        assertThat(isNoCountStrike).isTrue();
    }

    @Test
    @DisplayName("스트라이크의 개수가 0이 아닌지 확인한다.")
    void check_strike(){
        //given
        strike.updateStrikeCount(2);

        //when
        boolean isStrike = strike.isStrike();

        //then
        assertThat(isStrike).isTrue();
    }

    @Test
    @DisplayName("3스트라이크인지 확인한다.")
    void check_three_strike(){
        //given
        strike.updateStrikeCount(3);

        //when
        boolean isNotThreeStrike = strike.isNotThreeStrike();

        //then
        assertThat(isNotThreeStrike).isFalse();
    }
}
