package baseball.controller;

import baseball.error.ErrorException;
import baseball.error.GameInputErrorException;
import baseball.model.Computer;
import baseball.util.BaseballRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    void 숫자_야구_난수_유효성_테스트() {
        //given
        ErrorException errorException = new GameInputErrorException();
        List<Integer> checkNumber = new BaseballRandomNumberGenerator().generate();
        String checkNumberString =String.join("", checkNumber.stream().map(i -> String.valueOf(i)).collect(Collectors.toList()));

        //when,then
        System.out.println(checkNumberString);
        errorException.checkUserInputValidate(checkNumberString);

    }

}