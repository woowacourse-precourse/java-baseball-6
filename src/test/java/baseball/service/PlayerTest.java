package baseball.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    @DisplayName("플레이어 숫자 입력 성공")
    void checkNumberSuccess() {
        //given
        String input = "123";
        Player player = new Player();

        //when
        boolean result = player.isRandomNumbers(input);

        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("플레이어 숫자 입력 실패1 : 숫자가 아닌 문자 입력")
    void checkNumberFail1() {
        //given
        String input = "우테코";
        Player player = new Player();

        //when
        boolean result = player.isRandomNumbers(input);

        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("플레이어 숫자 입력 실패2 : 중복된 숫자 입력")
    void checkNumberFail2() {
        //given
        String input = "111";
        Player player = new Player();

        //when
        boolean result = player.isRandomNumbers(input);

        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("플레이어 숫자 입력 실패3 : 3자리 이상의 숫자 입력")
    void checkNumberFail3() {
        //given
        String input = "12345";
        Player player = new Player();

        //when
        boolean result = player.isRandomNumbers(input);

        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("플레이어 숫자 입력 실패3 : 범위 이외의 숫자 입력")
    void checkNumberFail4() {
        //given
        String input = "012";
        Player player = new Player();

        //when
        boolean result = player.isRandomNumbers(input);

        //then
        Assertions.assertEquals(false, result);
    }


}