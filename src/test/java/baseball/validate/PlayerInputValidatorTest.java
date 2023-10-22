package baseball.validate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerInputValidatorTest {

    PlayerInputValidator validator = new PlayerInputValidator();
    @Test
    void validateNumbers() {
        String input = "123";
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertEquals(numbers, validator.validateNumbers(input));
    }
    @Test
    void validateNumbersWithSpace() {
        String input = "1 2 3";
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertEquals(numbers, validator.validateNumbers(input));
    }
    @Test
    void validateNumbersErrorLimit3Length() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateNumbers("12"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateNumbers("1253"));
    }
    @Test
    void validateNumbersErrorContainsCharacters() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateNumbers("1@3"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateNumbers("a13"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateNumbers("12ㅁ"));
    }
    @Test
    void validateNumbersErrorContainsDuplicateNumbers() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateNumbers("112"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateNumbers("111"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateNumbers("322"));
    }
}