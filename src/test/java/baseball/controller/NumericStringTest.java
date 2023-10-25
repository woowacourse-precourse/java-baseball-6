package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericStringTest {

    @Test
    @DisplayName("숫자가 아닌 문자 입력 시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_inputForNotNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new NumericString(
                        "a13"));
    }

}
