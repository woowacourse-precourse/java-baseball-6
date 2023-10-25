package baseball.controller;

import baseball.error.ErrorException;
import baseball.error.GameInputErrorException;
import baseball.util.BaseballRandomNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class GameControllerTest {

    @Test
    void 숫자_야구_난수_유효성_테스트() {
        //given
        ErrorException errorException = new GameInputErrorException();
        List<Integer> checkNumber = new BaseballRandomNumberGenerator().generate();
        String checkNumberString =String.join("", checkNumber.stream().map(i -> String.valueOf(i)).collect(Collectors.toList()));

        //when,then
        System.out.println(checkNumberString);
        Assertions.assertDoesNotThrow(() ->
                errorException.checkUserInputValidate(checkNumberString));
    }
}