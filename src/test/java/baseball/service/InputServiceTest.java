package baseball.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputServiceTest {

    private final InputService inputService = InputService.getInstance();

    @Test
    void validateIntegerInput_Integer() {
        // 정수 입력을 검증, 예외가 발생하지 않아야 함
        inputService.validateIntegerInput("123");
    }

    @Test
    void validateIntegerInput_String() {
        // 비정수 문자 입력을 검증, 예외가 발생해야 함
        assertThrows(IllegalArgumentException.class, () -> {
            inputService.validateIntegerInput("abc");
        });
    }

    @Test
    void validateIntegerInput_emptyString() {
        // 빈 문자 입력을 검증, 예외가 발생해야 함
        assertThrows(IllegalArgumentException.class, () -> {
            inputService.validateIntegerInput("");
        });
    }
}
