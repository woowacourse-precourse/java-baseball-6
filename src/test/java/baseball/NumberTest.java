package baseball;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class NumberTest {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    @Test
    void 컴퓨터_숫자_검증() {
        Number computer = new Number();
        computer.setRandomNumber();

        checkRange(computer);
        checkCnt(computer);
        checkDuplicate(computer);
    }

    private void checkRange(Number number) {
        for(int digit: number.getDigits()) {
            assertFalse(digit < MIN_NUMBER || digit > MAX_NUMBER);
        }
    }

    private void checkCnt(Number number) {
        assertTrue(CNT_NUMBER == number.getDigits().length);
    }

    private void checkDuplicate(Number number) {
        int[] digits = number.getDigits();
        Set<Integer> digitSet = convertArrToSet(digits);

        assertTrue(digits.length == digitSet.size());
    }

    private Set<Integer> convertArrToSet(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toSet());
    }
}
