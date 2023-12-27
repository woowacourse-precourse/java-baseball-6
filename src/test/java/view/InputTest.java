package view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    Input input = new Input();


    @Test
    void testIsDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> input.isDuplicate("112"));
    }

    @Test
    void testIsNumber() {
        assertThrows(IllegalArgumentException.class, () -> input.isNumber("abc"));
    }

    @Test
    void testIsThree() {
        assertThrows(IllegalArgumentException.class, ()-> input.isThree("1234"));
    }

}