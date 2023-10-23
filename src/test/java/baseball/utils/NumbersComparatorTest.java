package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersComparatorTest {
    private NumbersComparator numbersComparator;
    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;

    @BeforeEach
    void setUp() {
        numbersComparator = new NumbersComparator();
        computerNumbers = Arrays.asList(1, 2, 3);
    }

    @Test
    @DisplayName("1, 1를 리턴합니다.")
    void 볼_스트라이크_리턴() {
        playerNumbers = Arrays.asList(4, 2, 1);
        int[] result = numbersComparator.getCompareNumberResult(computerNumbers, playerNumbers);
        assertArrayEquals(new int[]{1, 1}, result);
    }

    @Test
    @DisplayName("1, 0을 리턴합니다.")
    void 볼_리턴() {
        playerNumbers = Arrays.asList(4, 5, 1);
        int[] result = numbersComparator.getCompareNumberResult(computerNumbers, playerNumbers);
        assertArrayEquals(new int[]{1, 0}, result);
    }

    @Test
    @DisplayName("0, 1을 리턴합니다.")
    void 스트라이크_리턴() {
        playerNumbers = Arrays.asList(1, 4, 5);
        int[] result = numbersComparator.getCompareNumberResult(computerNumbers, playerNumbers);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    @DisplayName("0, 0을 리턴합니다.")
    void 낫싱_리턴() {
        playerNumbers = Arrays.asList(4, 5, 6);
        int[] result = numbersComparator.getCompareNumberResult(computerNumbers, playerNumbers);
        assertArrayEquals(new int[]{0, 0}, result);
    }

    @Test
    @DisplayName("3스트라이크일 때 true를 리턴하여 게임을 종료합니다.")
    void 게임_종료_리턴() {
        playerNumbers = Arrays.asList(1, 2, 3);
        numbersComparator.getCompareNumberResult(computerNumbers, playerNumbers);
        assertTrue(numbersComparator.isCorrect());
    }

    @Test
    @DisplayName("3스트라이크가 아닐 때 false를 리턴하여 게임을 재개합니다.")
    void 게임_재개_리턴() {
        playerNumbers = Arrays.asList(4, 5, 6);
        numbersComparator.getCompareNumberResult(computerNumbers, playerNumbers);
        assertFalse(numbersComparator.isCorrect());
    }
}