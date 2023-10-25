package baseball.utils;

import static baseball.constants.DigitConstants.NUMBER_RANGE_MAX;
import static baseball.constants.DigitConstants.NUMBER_RANGE_MIN;
import static baseball.constants.DigitConstants.NUMBER_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    public void 무작위로_생성된_숫자_리스트의_크기는_3이다() {
        // when
        List<Integer> result = RandomNumberGenerator.generateRandomNumbers();

        // then
        assertEquals(NUMBER_SIZE, result.size());
    }

    @Test
    public void 지정된_범위의_숫자_리스트를_생성한다() {
        // when
        List<Integer> result = RandomNumberGenerator.generateRandomNumbers();

        // then
        assertTrue(result.stream().allMatch(
                number -> number >= NUMBER_RANGE_MIN && number <= NUMBER_RANGE_MAX)
        );
    }

    @Test
    public void 리스트의_숫자는_중복이_불가능하다() {
        // when
        List<Integer> result = RandomNumberGenerator.generateRandomNumbers();

        // then
        List<Integer> distinctNumbers = result.stream().distinct().collect(Collectors.toList());
        assertEquals(result.size(), distinctNumbers.size());
    }
}