package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void isContainNumber() {
        // given
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(List.of(5, 1, 3));

        Number number1 = new Number(list1);
        Number number2 = new Number(list2);

        // when
        boolean firstIndex = number1.isContainNumber(number2, 0);
        boolean secondIndex = number1.isContainNumber(number2, 1);
        boolean thirdIndex = number1.isContainNumber(number2, 2);

        // then
        assertFalse(firstIndex);
        assertTrue(secondIndex);
        assertTrue(thirdIndex);
    }
}