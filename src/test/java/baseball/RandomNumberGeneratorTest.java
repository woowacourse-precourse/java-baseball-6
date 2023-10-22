package baseball;

import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.NumberBaseballGameConfig.*;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    private static final int TEST_CASE_COUNT = 50;

    @RepeatedTest(TEST_CASE_COUNT)
    public void 길이_테스트() {
        List<Integer> generated = RandomNumberGenerator.generate();
        assertEquals(BASEBALL_NUMBER_LENGTH, generated.size());
    }

    @RepeatedTest(TEST_CASE_COUNT)
    public void 각_자릿수_유일_테스트() {
        List<Integer> generated = RandomNumberGenerator.generate();
        Set<Integer> set = new HashSet<>(generated);
        assertEquals(generated.size(), set.size());
    }

    @RepeatedTest(TEST_CASE_COUNT)
    public void 각_자릿수_범위_테스트() {
        List<Integer> generated = RandomNumberGenerator.generate();
        assertTrue(generated.stream().allMatch(n -> n >= MIN_PLACE_VALUE && n <= MAX_PLACE_VALUE));
    }
}