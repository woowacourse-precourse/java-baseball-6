package baseball.dto.request;

import baseball.common.exception.input.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNumberRequestTest {
    @Test
    @DisplayName("숫자가 아닌 경우 예외가 발생한다.")
    public void 비숫자_입력() throws Exception {

        // given
        String arg = "Test";

        assertThrows(InputException.class, () -> {
            new UserNumberRequest(arg);
        });
    }
}