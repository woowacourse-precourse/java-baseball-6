package baseball.valid;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    @DisplayName("4글자 이므로 예외를 터트린다")
    void 사용자_Num_검증1() throws Exception {
        String test = "1234";
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateInputNum(test));
    }

    @Test
    @DisplayName("3글자여도 중복된 숫자가 있으므로 예외를 터트린다")
    void 사용자_Num_검증2() throws Exception {
        String test = "122";
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateInputNum(test));
    }

    @Test
    @DisplayName("숫자가 아닌게 들어가므로 예외를 터트린다")
    void 사용자_Num_검증3() throws Exception {
        String test = "1a2";
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateInputNum(test));
    }

    @Test
    @DisplayName("1이나 2가 아닌 다른 것이 들어가면 에러를 터트린다")
    void restart_Num_검증에러() throws Exception {
        List<String> testList = List.of("3", "35", "12", "bg");
        for (String test : testList) {
            assertThrows(IllegalArgumentException.class, () -> InputValidation.validateRestartNum(test));
        }
    }

    @Test
    @DisplayName("1이나 2가 들어갈 시 에러가 발생하지 않는다")
    void restart_Num_검증성공() throws Exception {
        List<String> testList = List.of("1", "2");
        for (String test : testList) {
            assertDoesNotThrow(() -> InputValidation.validateRestartNum(test));
        }
    }
}