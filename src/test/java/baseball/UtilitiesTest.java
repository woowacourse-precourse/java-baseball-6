package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static baseball.Utilities.combineStrings;
import static baseball.Utilities.stringLength;
import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @Test
    public void combineStringsTest() {
        String str1 = "Hi";
        String str2 = "Bye";
        Assertions.assertEquals(combineStrings(str1, str2), str1 + str2 );
    }

    @Test
    public void stringLengthTest() {
        String str = "123456";
        Assertions.assertEquals(stringLength(str), 6);
    }
}