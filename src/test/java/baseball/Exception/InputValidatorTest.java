package baseball.Exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    InputValidator inputValidator;
    @BeforeEach
    void set() {
        inputValidator = new InputValidator();
    }
    @Test
    void 세글자가_아닌_입력() {

        String test1 = "1234";

        Assertions.assertThatThrownBy(() -> inputValidator.doValidate(test1)).hasMessage(InputException.NOT_THREE.getMessage());
    }
    @Test
    void 숫자가_아닌_입략() {
        String test2 = "abc";
        Assertions.assertThatThrownBy(() -> inputValidator.doValidate(test2)).hasMessage(InputException.NOT_NUMBER.getMessage());
    }
    @Test
    void 중복_숫자_입력() {
        String test3 = "122";
        Assertions.assertThatThrownBy(() -> inputValidator.doValidate(test3)).hasMessage(InputException.HAS_DUPLICATE_NUMBER.getMessage());
    }

    @Test
    void 올바르지_않은_명령() {
        String wrongCommand = "a";
        Assertions.assertThatThrownBy(() -> inputValidator.validateCommand(wrongCommand)).hasMessage(InputException.WRONG_COMMAND.getMessage());
    }
}