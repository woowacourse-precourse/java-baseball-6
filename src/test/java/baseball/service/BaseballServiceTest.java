package baseball.service;

import baseball.dto.PlayerGameStateDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {




    @Test
    @DisplayName("strike,ball 잘 나오는지 테스트")
    void calculate() {
        //given
        String userNumber="123";
        String computerNumber= "234";
        BaseballService baseballService = new BaseballService(userNumber, computerNumber);

        //when
        PlayerGameStateDto gameState = baseballService.calculate();

        //then
        Assertions.assertThat(gameState.getStrike()).isEqualTo(0);
        Assertions.assertThat(gameState.getBall()).isEqualTo(2);
    }



}