package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    void ValidationTest() {
        //Given
        String[] invalidSize = {"1", "2", "3", "4"};
        String[] invalidInputValue = {"1","A","3"};
        String[] DuplicatedValue = {"1", "1", "2"};
        String[] invalidValueOfRestart = {"3"};
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