package baseball;

import static baseball.NumberBaseballGameConfig.BASEBALL_NUMBER_LENGTH;
import static baseball.NumberBaseballGameConfig.MAX_PLACE_VALUE;
import static baseball.NumberBaseballGameConfig.MIN_PLACE_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    private static final int TEST_CASE_COUNT = 50;
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @RepeatedTest(TEST_CASE_COUNT)
    public void 길이_테스트() {
        List<Integer> generated = randomNumberGenerator.generate();
        assertEquals(BASEBALL_NUMBER_LENGTH, generated.size());
    }

    @RepeatedTest(TEST_CASE_COUNT)
    public void 각_자릿수_유일_테스트() {
        List<Integer> generated = randomNumberGenerator.generate();
        Set<Integer> set = new HashSet<>(generated);
        assertEquals(generated.size(), set.size());
    }

    @RepeatedTest(TEST_CASE_COUNT)
    public void 각_자릿수_범위_테스트() {
        List<Integer> generated = randomNumberGenerator.generate();
        assertTrue(generated.stream().allMatch(n -> n >= MIN_PLACE_VALUE && n <= MAX_PLACE_VALUE));
    }
}