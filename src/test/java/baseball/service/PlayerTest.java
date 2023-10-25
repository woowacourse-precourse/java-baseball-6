package baseball.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    @DisplayName("플레이어 숫자 입력 성공")
    void checkRandomNumbersSuccess() {
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
    void checkRandomNumbersFail_숫자가_아닌_문자_입력() {
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
    void checkRandomNumbersFail_중복된_숫자_입력() {
        //given
        String input = "111";
        Player player = new Player();

        //when
        boolean result = player.isRandomNumbers(input);

        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("플레이어 숫자 입력 실패3 : 3자리가 아닌 숫자 입력")
    void checkRandomNumbersFail_3자리가_아닌_숫자_입력() {
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
    void checkRandomNumbersFail_범위_이외의_숫자_입력() {
        //given
        String input = "012";
        Player player = new Player();

        //when
        boolean result = player.isRandomNumbers(input);

        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("게임 종료시 숫자 입력 성공")
    void checkNumberSuccess() {
        //given
        String input = "1";
        Player player = new Player();
        //when
        boolean result = player.isNumber(input);
        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("게임 종료시 숫자 입력 실패1 : 숫자가 아닌 문자 입력")
    void checkNumberFail_숫자가_아닌_문자_입력() {
        //given
        String input = "이";
        Player player = new Player();
        //when
        boolean result = player.isNumber(input);
        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("게임 종료시 숫자 입력 실패2 : 범위 이외의 숫자 입력")
    void checkNumberFail_범위_이외의_숫자_입력() {
        //given
        String input = "3";
        Player player = new Player();
        //when
        boolean result = player.isNumber(input);
        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("게임 종료시 숫자 입력 실패3 : 1자리 이상의 숫자 입력")
    void checkNumberFail_1자리_이상의_숫자_입력() {
        //given
        String input = "12";
        Player player = new Player();
        //when
        boolean result = player.isNumber(input);
        //then
        Assertions.assertEquals(false, result);
    }
}