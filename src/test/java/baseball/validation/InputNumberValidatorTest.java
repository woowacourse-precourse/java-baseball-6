package baseball.validation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputNumberValidatorTest {

    @Test
    void String을_List로_변환() {
        String example = "316";
        assertTrue(InputNumberValidator.convertStrToList(example) instanceof List<Integer>);
    }

    @Test
    void 숫자가_세자리가_아니면_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validateInputSize(List.of(1, 2)));
    }
}