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

    @DisplayName("startGame 메소드가 3 스트라이크가 아닐 때 true를 반환하는가?")
    @Test
    public void testStartGameReturnsTrueIfNotThreeStrikes() {
        //given
        BaseballService baseballService = new BaseballService();
        //when
        String input = String.valueOf(123);
        String randomNumber = String.valueOf(125);
        //then
        assertThat(baseballService.startGame(input, randomNumber)).isTrue();
    }

    @DisplayName("countStrike 메소드가 스트라이크 수를 정확하게 계산하는가?")
    @Test
    public void testCountStrike_CorrectlyCountsStrikes() {
        //given
        BaseballService baseballService = new BaseballService();
        //when
        String input1 = String.valueOf(321);
        String randomNumber1 = String.valueOf(321);

        String input2 = String.valueOf(172);
        String randomNumber2 = String.valueOf(182);
        //then
        assertThat(baseballService.countStrike(randomNumber1, input1)).isEqualTo(3);
        assertThat(baseballService.countStrike(randomNumber2, input2)).isEqualTo(2);
    }

    @DisplayName("countBall 메소드가 볼 수를 정확하게 계산하는가?")
    @Test
    public void testCountBall_CorrectlyCountsBalls() {
        //given
        BaseballService baseballService = new BaseballService();
        //when
        String input1 = String.valueOf(132);
        String randomNumber1 = String.valueOf(321);

        String input2 = String.valueOf(172);
        String randomNumber2 = String.valueOf(289);
        //then
        assertThat(baseballService.countBall(randomNumber1, input1)).isEqualTo(3);
        assertThat(baseballService.countBall(randomNumber2, input2)).isEqualTo(1);
    }
}