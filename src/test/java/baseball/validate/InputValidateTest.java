package baseball.validate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputValidateTest {
    private InputValidate inputValidate;

    @BeforeEach
    void setUp() {
        this.inputValidate = new InputValidate();
    }
    @Test
    public void NumberS_TEST() {
        String given = "123";
        inputValidate.checkNumbers(given);
    }
    @Test
    public void NumberS_TEST_WRONG() {
        String given = "apple";
        Assertions.assertThrows(NumberFormatException.class, () -> inputValidate.checkNumbers(given));
    }

}