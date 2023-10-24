package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    @DisplayName("입력 오류 3자리 초과")
    void 사용자_입력_오류1() {
        String userInput = "1234";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("입력 오류 3자리 미만 : 1자리")
    void 사용자_입력_오류2_1() {
        String userInput = "1";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("입력 오류 3자리 미만 : 2자리")
    void 사용자_입력_오류2_2() {
        String userInput = "12";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

}