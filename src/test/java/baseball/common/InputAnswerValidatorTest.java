package baseball.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("재시작 입력 값 검증")
class InputAnswerValidatorTest {

    @Test
    @DisplayName("3 입력 시 예외 발생")
    void validateRestartAnswer() {
        //given
        String inputAnswer = "3";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputAnswerValidator.validate(inputAnswer));
    }

}