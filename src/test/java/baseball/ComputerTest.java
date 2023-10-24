package baseball;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ComputerTest {

    @Test
    void 볼과_스트라이크_점수를_계산한다() {
        Digits computerDigits = Digits.generateFixedDigits("123");
        Digits playerDigits = Digits.generateFixedDigits("132");

        try (MockedStatic<Digits> mDigits = mockStatic(Digits.class)) {
            // given
            mDigits.when(Digits::generateRandomDigits).thenReturn(computerDigits);
            Computer computer = new Computer();

            // when
            Result score = computer.calculateScore(playerDigits);

            // then
            assertEquals(score, new Result(2, 1));
        }
    }

    @Test
    void 재시작시_Digits를_재생성한다() {
        Computer computer = new Computer();
        try (MockedStatic<Digits> mDigits = mockStatic(Digits.class)) {
            // when
            computer.prepareGameRetry();

            // then
            mDigits.verify(Digits::generateRandomDigits, times(1));
        }
    }
}