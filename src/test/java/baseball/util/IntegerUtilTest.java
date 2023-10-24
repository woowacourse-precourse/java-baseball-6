package baseball.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class IntegerUtilTest {


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

}
