package domain;

import org.junit.jupiter.api.Test;

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
}
