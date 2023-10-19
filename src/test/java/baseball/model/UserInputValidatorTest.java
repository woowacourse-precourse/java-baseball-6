package baseball.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class UserInputValidatorTest {

    UserInputValidator validator = new UserInputValidator();

    @Test
    void 입력의_길이가_3이다() {
        assertTrue(validator.hasLengthOfThree("123"));
        assertThrows(IllegalArgumentException.class, () -> validator.hasLengthOfThree(""));
        assertThrows(IllegalArgumentException.class, () -> validator.hasLengthOfThree("1234"));
        assertThrows(IllegalArgumentException.class, () -> validator.hasLengthOfThree("ad"));

    }

    @Test
    void 입력이_숫자로만_이루어진다() {
        assertTrue(validator.isAllDigit("123"));
        assertThrows(IllegalArgumentException.class, () -> validator.isAllDigit("1a2"));
    }

    @Test
    void 입력이_숫자일때_1과_9사이_숫자다() {
        assertTrue(validator.isInRangeOfOneToNine("123"));
        assertThrows(IllegalArgumentException.class, () -> validator.isInRangeOfOneToNine("102"));
    }

    @Test
    void 입력이_숫자일때_모두_다른_숫자다() {
        assertTrue(validator.isUniqueNumber("123"));
        assertThrows(IllegalArgumentException.class, () -> validator.isUniqueNumber("112"));
    }

}