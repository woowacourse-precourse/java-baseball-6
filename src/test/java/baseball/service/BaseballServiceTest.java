package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {

    @DisplayName("startGame 메소드가 3 스트라이크일 때 false를 반환하는가?")
    @Test
    public void testStrikeIsThreeReturnFalse() {
        //given
        BaseballService baseballService = new BaseballService();
        //when
        String input = String.valueOf(123);
        String randomNumber = String.valueOf(123);
        //then
        assertThat(baseballService.startGame(input, randomNumber)).isFalse();
    }
}