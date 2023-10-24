package mytest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import baseball.model.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ModelTest {
    // given
    private static final int SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    @DisplayName("컴퓨터가 고른 수의 길이 확인")
    @Test
    void pickedNumbersSizeTest() {
        // when
        int[] result = RandomNumberGenerator.pickRandomNumbers(SIZE, MIN, MAX);

        // then
        assertEquals(SIZE, result.length);
    }

    @DisplayName("컴퓨터가 고른 수에 중복된 숫자 없는지 확인")
    @Test
    void pickedNumbersDuplicatesTest() {
        // when
        int[] result = RandomNumberGenerator.pickRandomNumbers(SIZE, MIN, MAX);

        // then
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                assertNotEquals(result[i], result[j]);
            }
        }
    }
}
