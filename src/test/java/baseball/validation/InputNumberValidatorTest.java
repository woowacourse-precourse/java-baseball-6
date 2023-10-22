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
}