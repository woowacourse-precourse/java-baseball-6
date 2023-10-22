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
}