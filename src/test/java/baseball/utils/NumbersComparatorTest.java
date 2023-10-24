package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @BeforeEach
    void setUp() {
        numbersComparator = new NumbersComparator();
        computerNumbers = Arrays.asList(1, 2, 3);
    }

    @Test
    @DisplayName("1, 1를 리턴합니다.")
    void 볼_스트라이크_리턴() {
        assertResult(Arrays.asList(4, 2, 1), Arrays.asList(1, 1));
    }

    @Test
    @DisplayName("1, 0을 리턴합니다.")
    void 볼_리턴() {
        assertResult(Arrays.asList(4, 5, 1), Arrays.asList(1, 0));
    }

    @Test
    @DisplayName("0, 1을 리턴합니다.")
    void 스트라이크_리턴() {
        assertResult(Arrays.asList(1, 4, 5), Arrays.asList(0, 1));
    }

    @Test
    @DisplayName("0, 0을 리턴합니다.")
    void 낫싱_리턴() {
        assertResult(Arrays.asList(4, 5, 6), Arrays.asList(0, 0));
    }

    @Test
    @DisplayName("3스트라이크일 때 true를 리턴하여 게임을 종료합니다.")
    void 게임_종료_리턴() {
        assertResult(Arrays.asList(1, 2, 3), Arrays.asList(0, 3));
        assertTrue(numbersComparator.isCorrect());
    }

    @Test
    @DisplayName("3스트라이크가 아닐 때 false를 리턴하여 게임을 재개합니다.")
    void 게임_재개_리턴() {
        assertResult(Arrays.asList(4, 5, 6), Arrays.asList(0, 0));
        assertFalse(numbersComparator.isCorrect());
    }

    private void assertResult(List<Integer> playerNumbers, List<Integer> expected) {
        List<Integer> result = numbersComparator.getCompareNumberResult(computerNumbers, playerNumbers);
        assertEquals(expected, result);
    }
}