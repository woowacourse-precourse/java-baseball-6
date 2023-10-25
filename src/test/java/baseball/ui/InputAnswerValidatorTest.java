package baseball.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.ui.input.validator.InputAnswerValidator;
import baseball.ui.input.validator.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputAnswerValidatorTest {

    private final InputValidator validator = new InputAnswerValidator();

    @Test
    public void 입력은_3자리_정수이다() {
        String validUserInput = "123";
        assertEquals(validator.validateInput(validUserInput), "123");
    }

    @Test
    public void 입력은_null이_아니다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String nullUserInput = null;
            validator.validateInput(nullUserInput);
        });

        assertThat(i.getMessage().contains("입력은 null일 수 업습니다."));
    }

    @Test
    public void 입력은_3자리보다_작으면_유효하지않다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String shortUserInput = "12";
            validator.validateInput(shortUserInput);
        });

        assertThat(i.getMessage().contains("입력은 3 자리여야 합니다."));
    }

    @Test
    public void 입력은_3자리보다_크면_유효하지않다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String longUserInput = "1234";
            validator.validateInput(longUserInput);
        });

        assertThat(i.getMessage().contains("입력은 3 자리여야 합니다."));
    }

    @Test
    public void 입력은_정수가아니면_유효하지않다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String stringUserInput = "asdg";
            validator.validateInput(stringUserInput);
        });

        assertThat(i.getMessage().contains("입력은 3 자리 정수값이어야합니다. 입력하신 값 : asdg"));
    }

}