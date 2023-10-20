package baseball.valid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    @DisplayName("4글자 이므로 예외를 터트린다")
    void 사용자_Num_검증1() throws Exception{
        String test = "1234";
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateInputNum(test));
    }

    @Test
    @DisplayName("3글자여도 중복된 숫자가 있으므로 예외를 터트린다")
    void 사용자_Num_검증2() throws Exception{
        String test = "122";
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateInputNum(test));
    }

    @Test
    @DisplayName("숫자가 아닌게 들어가므로 예외를 터트린다")
    void 사용자_Num_검증3() throws Exception{
        String test = "1a2";
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateInputNum(test));
    }
}