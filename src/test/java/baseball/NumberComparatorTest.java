package baseball;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberComparatorTest {
    @DisplayName("같은 수일 경우 true 출력")
    @Test
    void returnTrue() {
        assertTrue(NumberComparator.isEqual(5,5));
    }

    @DisplayName("다른 수일 경우 false 출력")
    @Test
    void returnFalse() {
        assertFalse(NumberComparator.isEqual(3,6));
    }
}
