package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    void isValidSizeTest() {
        //given
        String input = "4241";
        int size = 3;

        //when
        Validator validator = new Validator();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.checkValid(input, size));

        assertEquals("올바른 자리 수의 값을 입력하세요.", exception.getMessage());
    }

    @Test
    void isIntegerTest() {
        //given
        String inputWithString = "1a2";
        String inputWithZero = "102";
        int size = 3;

        //when
        Validator validator = new Validator();

        //then
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> validator.checkValid(inputWithString, size));

        assertEquals("1부터 9까지의 수를 입력하세요.", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> validator.checkValid(inputWithZero, size));

        assertEquals("1부터 9까지의 수를 입력하세요.", exception2.getMessage());
    }

    @Test
    void isDuplicateTest() {
        //given
        String input = "112";
        int size = 3;

        //when
        Validator validator = new Validator();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkValid(input, size));

        assertEquals("중복된 숫자를 포함하고 있습니다.", exception.getMessage());
    }

}
