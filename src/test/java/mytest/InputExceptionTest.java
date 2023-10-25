package mytest;

import model.PlayerNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputExceptionTest {
    //예외테스트
    @Test
    void 숫자가아닌_입력(){
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerNumber.isAllDigits("12#@");
        });
    }
    @Test
    void 네자리가아닌_입력(){
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerNumber.isValidNumber("1234");
        });
    }
    @Test
    void 중복된_숫자_입력(){
        assertThrows(IllegalArgumentException.class, () -> {
            PlayerNumber.hasNoDuplicates("2234");
        });
    }


}
