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

}