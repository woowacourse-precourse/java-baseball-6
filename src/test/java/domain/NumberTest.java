package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void 생성되는_숫자가_중복되지_않는가() {
        boolean result = true;
        List<Integer> goalNumbers = Number.getGoalNumbers();
        for (int i = 0; i < goalNumbers.size(); i++) {
            if (goalNumbers.get(i) < 1 || goalNumbers.get(i) > 9) {
                result = false;
            }
            for (int j = 0; j < i; j++) {
                if (goalNumbers.get(i).equals(goalNumbers.get(j))) {
                    result = false;
                }
            }
        }
        assertTrue(result);
    }

    @Test
    void 점수_계산이_올바르게_진행되는가() {
        List<Integer> goalNumbers = Number.getGoalNumbers();
        List<Number> numbers = List.of(
                new Number(goalNumbers.get(0)),
                new Number(goalNumbers.get(1)),
                new Number(goalNumbers.get(2))
                );
        assertEquals(3, Number.getStrike(numbers));
        assertEquals(0, Number.getBall(numbers));

        numbers = List.of(
                new Number(goalNumbers.get(1)),
                new Number(goalNumbers.get(0)),
                new Number(goalNumbers.get(2))
        );
        assertEquals(1, Number.getStrike(numbers));
        assertEquals(2, Number.getBall(numbers));
    }
}
