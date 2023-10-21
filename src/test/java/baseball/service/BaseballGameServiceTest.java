package baseball.service;

import baseball.servcie.BaseballGameService;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class BaseballGameServiceTest {

    private final BaseballGameService baseballGameService;

    BaseballGameServiceTest() {
        this.baseballGameService = new BaseballGameService();
    }


    @Test
    @DisplayName("재시작 시 입력 값 1 입력(True) - 성공")
    public void checkRestartTrueSuccess() {
        //given
        String checkString = "1";

        //when
        System.setIn(new ByteArrayInputStream(checkString.getBytes()));
        boolean checkContinue = baseballGameService.checkRestart();

        //then
        Assertions.assertThat(checkContinue).isTrue();


        Console.close();
    }

    @Test
    @DisplayName("재시작 시 입력 값 2 입력(False) - 성공")
    public void checkRestartFalseSuccess() {
        //given
        String checkString = "2";

        //when
        System.setIn(new ByteArrayInputStream(checkString.getBytes()));
        boolean checkContinue = baseballGameService.checkRestart();

        //then
        Assertions.assertThat(checkContinue).isFalse();


        Console.close();
    }

    @Test
    @DisplayName("재시작 시 입력 값 잘못 입력 - 실패")
    public void checkRestartFail() {
        //given
        String checkString = "123";

        //when
        System.setIn(new ByteArrayInputStream(checkString.getBytes()));

        //then
        Assertions.assertThatThrownBy(() -> baseballGameService.checkRestart())
                .isInstanceOf(IllegalArgumentException.class);


        Console.close();
    }
}