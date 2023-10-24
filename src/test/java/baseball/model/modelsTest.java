package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class modelsTest {
    @DisplayName("1 또는 2를 입력 받았습니다.")
    @Test
    public void testValidateStringOneorTwoWithValidInput() {
        // 유효한 입력("1" 또는 "2")을 넣어서 예외가 발생하지 않아야 합니다.
        Models.validateStringOneorTwo("1");
        Models.validateStringOneorTwo("2");
    }

    @DisplayName("유효하지않은 값을 입력 받았습니다.")
    @Test
    public void testValidateStringOneorTwoWithInvalidInput() {
        // 유효하지 않은 입력을 넣어서 IllegalArgumentException이 발생해야 합니다.
        assertThrows(IllegalArgumentException.class, () -> {
            Models.validateStringOneorTwo("3");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Models.validateStringOneorTwo("abc");
        });
    }



}
