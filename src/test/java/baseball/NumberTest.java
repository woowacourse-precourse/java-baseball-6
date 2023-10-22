package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberTest {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private static Number number;

    @BeforeEach
    private void createNumber() {
        number = new Number();
    }

    @Test
    void 컴퓨터_숫자_검증() {
        number.setRandomNumber();
        assertTrue(checkVaild());
    }

    @Test
    void 올바른_숫자_입력() {
        number.inputAnswer("123");
        assertTrue(checkVaild());
    }

    @Test
    void 문자_입력() {
        assertThrows( IllegalArgumentException.class,
                () -> number.inputAnswer("abc")
        );
    }

    @Test
    void 올바르지_않은_입력_길이() {
        assertThrows( IllegalArgumentException.class,
                () -> number.inputAnswer("1234")
        );
    }

    @Test
    void 올바르지_않은_입력_범위() {
        assertThrows( IllegalArgumentException.class,
                () -> number.inputAnswer("102")
        );
    }

    @Test
    void 중복이_존재하는_입력() {
        assertThrows( IllegalArgumentException.class,
                () -> number.inputAnswer("112")
        );
    }

    private boolean checkVaild() {
        return checkRange()
                && checkCnt()
                && checkDuplicate();
    }

    private boolean checkRange() {
        for(int digit: number.getDigits()) {
            if(digit < MIN_NUMBER || digit > MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCnt() {
        return CNT_NUMBER == number.getDigits().length;
    }

    private boolean checkDuplicate() {
        int[] digits = number.getDigits();
        Set<Integer> digitSet = convertArrToSet(digits);

        return digits.length == digitSet.size();
    }

    private Set<Integer> convertArrToSet(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toSet());
    }
}
