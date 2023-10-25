package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.utils.Utils;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    public void testValidateRestartOrExitInput() {
        assertDoesNotThrow(() -> Utils.validateRestartOrExitInput("1"));
        assertDoesNotThrow(() -> Utils.validateRestartOrExitInput("2"));
        assertThrows(IllegalArgumentException.class, () -> Utils.validateRestartOrExitInput("3"));
    }

    @Test
    public void testCreateRandomNumberList() {
        List<Integer> result = Utils.createRandomNumberList(3);
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(num -> num >= 1 && num <= 9));
    }

    @Test
    public void testValidateUserInput() {
        assertDoesNotThrow(() -> Utils.validateUserInput("123"));
        assertThrows(IllegalArgumentException.class, () -> Utils.validateUserInput("12"));
        assertThrows(IllegalArgumentException.class, () -> Utils.validateUserInput("120"));
        assertThrows(IllegalArgumentException.class, () -> Utils.validateUserInput("112"));
    }

    @Test
    public void testStringToIntegerList() {
        List<Integer> result = Utils.stringToIntegerList("456");
        assertEquals(Arrays.asList(4, 5, 6), result);
    }
}