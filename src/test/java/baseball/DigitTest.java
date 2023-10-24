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
        assertThrows(IllegalArgumentException.class, () -> Digit.generateFixedDigit(target));
    }

    @ParameterizedTest
    @ValueSource(chars = {1, 5, 9})
    void digit이_1에서_9사이_숫자인경우_예외가_던져지지_않는다(int target) {
        assertDoesNotThrow(() -> Digit.generateFixedDigit(target));
    }

    @Test
    void digit의_숫자가_같을_경우_동일한_객체로_인식한다() {
        Digit digit1 = Digit.generateFixedDigit(5);
        Digit digit2 = Digit.generateFixedDigit(5);

        assertEquals(digit1, digit2);
    }

    @Test
    void 숫자가_같다고_같은_Digit으로_인식하지는_않는다() {
        Integer digit1 = 5;
        Digit digit2 = Digit.generateFixedDigit(5);

        assertNotEquals(digit1, digit2);
    }

    @Test
    void 같은_숫자를_가진_Digit객체는_Hash_Collection_자료구조에서도_동일한_객체로_인식된다() {
        Digit digit1 = Digit.generateFixedDigit(5);
        Digit digit2 = Digit.generateFixedDigit(5);

        Set<Digit> set = new HashSet<>();
        set.add(digit1);
        set.add(digit2);

        assertEquals(set.size(), 1);
    }

}