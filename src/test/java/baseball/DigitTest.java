package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DigitTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void digit이_1에서_9사이_숫자가_아닌경우_IllegalArgumentException_예외를_던진다(int target) {
        assertThrows(IllegalArgumentException.class, () -> new Digit(target));
    }

    @ParameterizedTest
    @ValueSource(chars = {1, 5, 9})
    void digit이_1에서_9사이_숫자인경우_예외가_던져지지_않는다(int target) {
        assertDoesNotThrow(() -> new Digit(target));
    }


}