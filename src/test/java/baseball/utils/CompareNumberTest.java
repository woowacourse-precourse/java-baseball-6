package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompareNumberTest {

    @Test
    @DisplayName("1, 1를 리턴합니다.")
    void x볼y스트라이크() {
        CompareNumber compareNumber = new CompareNumber();

        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 2, 1);

        int[] result = compareNumber.getCompareNumberResult(computerNumbers, playerNumbers);

        assertArrayEquals(new int[]{1, 1}, result);
    }

    @Test
    @DisplayName("1, 0을 리턴합니다.")
    void x볼() {
        CompareNumber compareNumber = new CompareNumber();

        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 5, 1);

        int[] result = compareNumber.getCompareNumberResult(computerNumbers, playerNumbers);

        assertArrayEquals(new int[]{1, 0}, result);
    }

    @Test
    @DisplayName("0, 1을 리턴합니다.")
    void y스트라이크() {
        CompareNumber compareNumber = new CompareNumber();

        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 4, 5);

        int[] result = compareNumber.getCompareNumberResult(computerNumbers, playerNumbers);

        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    @DisplayName("0, 0을 리턴합니다.")
    void 낫싱() {
        CompareNumber compareNumber = new CompareNumber();

        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 5, 6);

        int[] result = compareNumber.getCompareNumberResult(computerNumbers, playerNumbers);

        assertArrayEquals(new int[]{0, 0}, result);
    }

    @Test
    @DisplayName("3스트라이크일 때 true를 리턴합니다.")
    void 게임종료() {
        CompareNumber compareNumber = new CompareNumber();

        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);

        compareNumber.getCompareNumberResult(computerNumbers, playerNumbers);

        assertTrue(compareNumber.isCorrect());
    }

    @Test
    @DisplayName("3스트라이크가 아닐 때 false를 리턴합니다.")
    void 게임재개() {
        CompareNumber compareNumber = new CompareNumber();

        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 5, 6);

        compareNumber.getCompareNumberResult(computerNumbers, playerNumbers);

        assertFalse(compareNumber.isCorrect());
    }
}