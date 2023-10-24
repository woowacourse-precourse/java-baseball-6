package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntegerUtilTest {

    @Test
    public void isInteger_Integer() {
        assertTrue(IntegerUtil.isInteger("123"));
        assertTrue(IntegerUtil.isInteger("-456"));
    }

    @Test
    public void isInteger_NonInteger() {
        assertFalse(IntegerUtil.isInteger("abc"));
        assertFalse(IntegerUtil.isInteger("12.34"));
        assertFalse(IntegerUtil.isInteger("12345678901234567890"));
    }

    @Test
    void validateInteger_Integer() {
        IntegerUtil.validateInteger("123");
    }

    @Test
    void validateInteger_String() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerUtil.validateInteger("abc");
        });
    }

    @Test
    void validateInteger_emptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerUtil.validateInteger("");
        });
    }

    @Test
    public void isSame_true() {
        //given
        Integer i1 = 42;
        Integer i2 = 42;

        //when
        boolean result = IntegerUtil.isSame(i1, i2);

        //then
        assertTrue(result);
    }

    @Test
    public void isSame_false() {
        Integer i1 = 42;
        Integer i2 = 17;

        boolean result = IntegerUtil.isSame(i1, i2);

        assertFalse(result);
    }

    @Test
    public void testParseInteger() {
        char character = '7';

        Integer result = IntegerUtil.parseInteger(character);

        assertEquals(Integer.valueOf(7), result);
    }
}
