package baseball.domain;

import baseball.validation.Validation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    void ValidationTest() {
        //Given
        char[] invalidSize = {'1', '2', '3', '4'};
        char[] invalidInputValue = {'1', 'A', '3'};
        char[] DuplicatedValue = {'1', '1', '2'};
        char[] invalidValueOfRestart = {'3'};
        //When & Then
        Assertions.assertThatThrownBy(() -> validation.runValidation(invalidSize, 3))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validation.runValidation(invalidInputValue, 3))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validation.runValidation(DuplicatedValue, 3))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validation.runValidation(invalidValueOfRestart, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}