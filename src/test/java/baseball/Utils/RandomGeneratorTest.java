package baseball.Utils;

import baseball.Util.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGeneratorTest {
    List<Integer> randomThreeNumbers = RandomNumberGenerator.generateRandomThreeNumber();

    @Test
    @DisplayName("세자리인지 확인")
    public void isThreeDigit() {
        assertEquals(randomThreeNumbers.size(), 3);
    }

    @Test
    @DisplayName("1~9 사이의 숫자로 이루어져 있는지 확인")
    public void isNumber() {
        for (int number : randomThreeNumbers) {
            assertTrue(number >= 1);
            assertTrue(number <= 9);
        }
    }

    @Test
    @DisplayName("중복숫자 확인")
    public void isUnique() {
        assertEquals(randomThreeNumbers.size(), randomThreeNumbers.stream().distinct().count() );
    }
}
