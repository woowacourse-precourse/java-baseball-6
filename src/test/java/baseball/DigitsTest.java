package baseball;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class DigitsTest {

    @Test
    void 랜덤으로_생성된_Digits는_유니크한_세자리_숫자를_가진다() {

        // given
        Digits comparisonDigits = Digits.generateFixedDigits("123");
        Digit digit1 = Digit.generateFixedDigit(1);
        Digit digit2 = Digit.generateFixedDigit(2);
        Digit digit3 = Digit.generateFixedDigit(3);
        try (MockedStatic<Digit> mDigit = mockStatic(Digit.class)) {
            mDigit.when(Digit::generateRandomDigit)
                    .thenReturn(digit1)
                    .thenReturn(digit1)
                    .thenReturn(digit1)
                    .thenReturn(digit2)
                    .thenReturn(digit3);

            // when
            Digits digits = Digits.generateRandomDigits();

            // then
            assertEquals(digits, comparisonDigits);
        }
    }

    @Test
    void 사용자_입력값으로_생성된_Digits는_세자리수가_아닐경우_IllegalArgumentException_예외를_던진다() {
        assertThrows(IllegalArgumentException.class, () -> Digits.generateFixedDigits("1234"));
    }

    @Test
    void 사용자_입력값으로_생성된_Digits는_중복된_수가_있을경우_IllegalArgumentException_예외를_던진다() {
        assertThrows(IllegalArgumentException.class, () -> Digits.generateFixedDigits("112"));
    }

    @Test
    void 입력값의_ball_점수를_count_한다() {
        Digits computerDigits = Digits.generateFixedDigits("123");
        Digits userInput = Digits.generateFixedDigits("231");

        int ballCount = computerDigits.countBall(userInput);

        assertEquals(ballCount, 3);
    }

    @Test
    void 입력값의_strike_점수를_count_한다() {
        Digits computerDigits = Digits.generateFixedDigits("123");
        Digits userInput = Digits.generateFixedDigits("124");

        int strikeCount = computerDigits.countStrike(userInput);

        assertEquals(strikeCount, 2);
    }

    @Test
    void Digits_내의_원소가_같을_경우_동일한_객체로_인식한다() {
        Digits digits1 = Digits.generateFixedDigits("123");
        Digits digits2 = Digits.generateFixedDigits("123");

        assertEquals(digits1, digits2);
    }

    @Test
    void Collection내의_원소가_같다고_동일한_객체로_인식하지는_않는다() {
        Digits digits1 = Digits.generateFixedDigits("123");
        List<Integer> list = List.of(1, 2, 3);

        assertNotEquals(digits1, list);
    }

    @Test
    void 같은_원소를_가진_Digits객체는_Hash_Collection_자료구조에서도_동일한_객체로_인식된다() {
        Digits digits1 = Digits.generateFixedDigits("123");
        Digits digits2 = Digits.generateFixedDigits("123");

        Set<Digits> set = new HashSet<>();
        set.add(digits1);
        set.add(digits2);

        assertEquals(set.size(), 1);
    }
}