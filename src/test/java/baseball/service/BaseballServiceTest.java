package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import baseball.dto.GameStateDto;
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
        GameStateDto gameState = baseballService.calculate();

        //then
        Assertions.assertThat(gameState.getStrike()).isEqualTo(0);
        Assertions.assertThat(gameState.getBall()).isEqualTo(2);
    }



}