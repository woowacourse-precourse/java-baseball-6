package study;

import static org.junit.jupiter.api.Assertions.*;

import baseball.model.UserNumber;
import org.junit.jupiter.api.Test;

class UserNumberTest {

    @Test
    void invalidLengthTest(){
        assertThrows(IllegalArgumentException.class, () -> new UserNumber("1234"));
    }

    @Test
    void duplicateNumberTest(){
        assertThrows(IllegalArgumentException.class, () -> new UserNumber("112"));
    }

    @Test
    void nonDigitInputTest() {
        assertThrows(IllegalArgumentException.class, () -> new UserNumber("1a2"));
    }

    @Test
    void outOfRangeTest() {
        assertThrows(IllegalArgumentException.class, () -> new UserNumber("012"));
    }

    @Test
    void validInputTest() {
        UserNumber userNumber = new UserNumber("123");
        assertEquals(3, userNumber.getUserNumber().size());
        assertEquals(1, userNumber.getUserNumber().get(0));
        assertEquals(2, userNumber.getUserNumber().get(1));
        assertEquals(3, userNumber.getUserNumber().get(2));
    }
}