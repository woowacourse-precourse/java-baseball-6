package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 리스트를_이용한_숫자_생성() {
        // given
        List<Integer> inputDigits = Arrays.asList(1, 2, 3);

        // when
        Number number = new Number(inputDigits);

        // then
        assertEquals(1, number.firstDigit);
        assertEquals(2, number.secondDigit);
        assertEquals(3, number.thirdDigit);
    }

    @Test
    void 정수를_이용한_숫자_생성() {
        // given
        int inputNumber = 456;

        // when
        Number number = new Number(inputNumber);

        // then
        assertEquals(4, number.firstDigit);
        assertEquals(5, number.secondDigit);
        assertEquals(6, number.thirdDigit);
    }

    @Test
    void 숫자_포함_여부_확인() {

        // given
        List<Integer> inputDigits = Arrays.asList(1, 2, 3);

        // when
        Number number = new Number(inputDigits);

        // then
        assertTrue(number.contains(1));
        assertTrue(number.contains(2));
        assertTrue(number.contains(3));
        assertFalse(number.contains(4));
    }

    @Test
    void 잘못된_숫자_입력_예외처리() {
        // given
        int inputNumber = 023;

        // then
        assertThrows(IllegalArgumentException.class,
                () -> new Number(inputNumber));
    }

    @Test
    void 중복된_숫자_입력_예외처리() {
        // given
        int inputNumber = 122;

        // then
        assertThrows(IllegalArgumentException.class,
                () -> new Number(inputNumber));
    }

}