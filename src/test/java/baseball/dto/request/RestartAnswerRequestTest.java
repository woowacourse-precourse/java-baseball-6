package baseball.dto.request;

import baseball.common.exception.input.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestartAnswerRequestTest {
    @Test
    @DisplayName("1, 2 외에 다른 값인 경우 예외가 발생한다.")
    public void 잘못된_값_입력() throws Exception {
        String arg = "3";
        assertThrows(InputException.class, () -> {
            new RestartAnswerRequest(arg);
        });
    }
}