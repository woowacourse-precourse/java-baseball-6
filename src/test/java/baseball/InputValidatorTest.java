package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static baseball.InputValidator.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    public void isNullTest() {
        String input = null;
        assertThrows(IllegalArgumentException.class, () -> {
            isNull(input);
        });
    }

    @Test
    public void isLengthThreeTest() {
        String input = "1561516516";
        assertThrows(IllegalArgumentException.class, () -> {
            isLengthThree(input);
        });
    }

    @Test
    public void isDuplicateNumberTest() {
        String input = "122";
        assertThrows(IllegalArgumentException.class, () -> {
            isDuplicateNumber(input);
        });
    }

    @Test
    public void containOneOrTwoTest() {
        String input = "122";
        assertThrows(IllegalArgumentException.class, () -> {
            containOneOrTwo(input);
        });
    }



}