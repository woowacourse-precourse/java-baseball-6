package baseball.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInputValidatorTest {

    private final UserInputValidator validator = new UserInputValidator();

    @Test
    public void 입력은_3자리_정수이다() {
        String validUserInput = "123";
        assertEquals(validator.check(validUserInput), "123");
    }

    @Test
    public void 입력은_null이_아니다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String nullUserInput = null;
            validator.check(nullUserInput);
        });

        assertThat(i.getMessage().contains("입력은 세 자리 수의 정수여야 합니다."));
    }

    @Test
    public void 입력은_3자리보다_작으면_유효하지않다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String shortUserInput = "12";
            validator.check(shortUserInput);
        });

        assertThat(i.getMessage().contains("입력은 세 자리 수의 정수여야 합니다."));
    }

    @Test
    public void 입력은_3자리보다_크면_유효하지않다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String longUserInput = "1234";
            validator.check(longUserInput);
        });

        assertThat(i.getMessage().contains("입력은 세 자리 수의 정수여야 합니다."));
    }

    @Test
    public void 입력은_정수가아니면_유효하지않다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String stringUserInput = "asdg";
            validator.check(stringUserInput);
        });

        assertThat(i.getMessage().contains("입력은 세 자리 수의 정수여야 합니다."));
    }

}