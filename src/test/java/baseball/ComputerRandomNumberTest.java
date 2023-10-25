package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static baseball.ComputerRandomNumber.pickNumberSet;
import static org.junit.jupiter.api.Assertions.*;

class ComputerRandomNumberTest {
/*
    @RepeatedTest(10000)
    public void isPickNumberInRangeTest() {
        int value = ComputerRandomNumber.pickNumber();
        int minValue = 1;
        int maxValue = 9;
        Assertions.assertTrue(value >= minValue && value <= maxValue);
    }
 */

    @Test
    public void isSetSizeOfThreeTest() {
        Set<Integer> set = new HashSet<>();
        set = ComputerRandomNumber.pickNumberSet();
        Assertions.assertEquals(set.size(), 3);
    }

    @Test
    public void setToStringTest() {
        Set<Integer> stringSet = new HashSet<>();
        stringSet.add(1);
        stringSet.add(2);
        stringSet.add(3);

        String result = ComputerRandomNumber.setToString(stringSet);

        String expected = "123";
        assertEquals(expected, result);
    }
/*
    @RepeatedTest(10000)
    public void pickNumberSetToStringTest() {
        String result = ComputerRandomNumber.pickNumberSetToString();
        String expected = "144";
        assertNotEquals(expected, result);
    }

    @RepeatedTest(10000)
    public void isRandomNumberThreeDigitsTest() {
        String randomNumber = ComputerRandomNumber.generateRandomNumber();
        Assertions.assertEquals(randomNumber.length(), 3);
    }
 */


}