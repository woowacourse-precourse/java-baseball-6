package baseball.controller.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameDtoTest {

    @Test
    @DisplayName("빈문자열 입력 시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_inputEmptyString() {
        assertThrows(IllegalArgumentException.class, () ->
                new BaseBallGameDto(
                        ""));
    }


    @Test
    @DisplayName("null 입력 시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_inputNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new BaseBallGameDto(
                        ""));
    }

}
