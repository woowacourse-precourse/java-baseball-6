package baseball.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RestartOrExitValidatorTest {

    @Test
    public void 재시작_혹은_종료_여부를_정상적으로_입력한다() {
        // given
        String inputString = "1";

        // when & then
        assertDoesNotThrow(() -> RestartOrExitValidator.validateRestartOrExit(inputString));
    }

    @Test
    public void 입력의_크기가_2이상인_경우_예외를_반환한다() {
        // given
        String inputString = "12";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> RestartOrExitValidator.validateRestartOrExit(inputString));
    }

    @Test
    public void 주어진_입력이_아니라면_예외를_반환한다() {
        // given
        String inputString = "9";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> RestartOrExitValidator.validateRestartOrExit(inputString));
    }
}