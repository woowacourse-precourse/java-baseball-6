package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.util.constants.BaseballGameConstants;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("Numbers 클래스의 random() 테스트")
public class NumbersRandomGenerateTest {
    @RepeatedTest(value = 5)
    @DisplayName("길이 확인")
    void testLength() {
        Numbers numbers = Numbers.random();
        assertEquals(BaseballGameConstants.NUM_LENGTH, numbers.getNumbers().length);
    }

    @RepeatedTest(value = 5)
    @DisplayName("범위 확인")
    void testRange() {
        Numbers numbers = Numbers.random();
        assertTrue(Arrays.stream(numbers.getNumbers())
                .allMatch(v -> v >= BaseballGameConstants.MIN_NUM && v <= BaseballGameConstants.MAX_NUM));
    }

    @RepeatedTest(value = 5)
    @DisplayName("중복 확인")
    void testNotDuplicated() {
        Numbers numbers = Numbers.random();
        long distinctCount = Arrays.stream(numbers.getNumbers()).distinct().count();
        assertEquals(numbers.getNumbers().length, distinctCount);
    }

}
