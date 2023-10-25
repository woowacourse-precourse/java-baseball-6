package baseball.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputResumeValidatorTest {

    private final InputValidator validator = new InputResumeValidator();

    @Test
    public void 재시작여부는_1자리_정수이다() {
        String validUserInput = "1";
        assertEquals(validator.validateInput(validUserInput), "1");
    }

    @Test
    public void 재시작여부는_1_혹은_2_아니면_유효하지않다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String stringUserInput = "3";
            validator.validateInput(stringUserInput);
        });

        assertThat(i.getMessage().contains("입력은 1 혹은 2의 값이어야합니다. 입력하신 값 : 3"));
    }

    @Test
    public void 재시작여부는_null이_아니다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String nullUserInput = null;
            validator.validateInput(nullUserInput);
        });

        assertThat(i.getMessage().contains("입력은 null일 수 업습니다."));
    }

    @Test
    public void 재시작여부는_정수가아니면_유효하지않다() {
        IllegalArgumentException i = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String stringUserInput = "a";
            validator.validateInput(stringUserInput);
        });

        assertThat(i.getMessage().contains("입력은 1 혹은 2의 값이어야합니다. 입력하신 값 : a"));
    }

}
