package baseball.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("플레이어로부터 서로 다른 3자리의 수를 입력 받는다.")
    @Test
    void setPlayerNumber() throws Exception{
        //given
        Player player = new Player("123");

        //when //then
        assertThat(player.getPlayerNumber()).isEqualTo("123");
    }

}