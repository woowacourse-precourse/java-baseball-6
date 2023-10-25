package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static baseball.Utilities.*;
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

    @Test
    public void stringSplitTOArrayTest() {
        String str = "toggle";
        String[] expected = {"t", "o", "g", "g", "l", "e"};
        String[] result = stringSplitToCharactersArray(str);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void arrayToSetTest() {
        String[] array = {"t", "o", "g", "g", "l", "e"};
        Set<String> expectedSet = new HashSet<>(Arrays.asList("t", "o", "g", "l", "e"));
        Assertions.assertEquals(expectedSet, arrayToSet(array));
    }

    @Test
    public void sizeOfSetTest() {
        Set<String> set = new HashSet<>(Arrays.asList("a", "p", "p", "l", "e"));
        Assertions.assertEquals(sizeOfSet(set),4);
    }

    @Test
    public void countTwoStringSameTest() {
        String[] strArray1 = {"1", "2", "3", "4"};
        String[] strArray2 = {"4", "2", "5", "1"};
        Assertions.assertEquals(countTwoStringSame(strArray1, strArray2),1);
    }
}