package utilTests;

import baseball.container.ApplicationContainer;
import baseball.util.generator.RandomNumberGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberGeneratorTests {
    private final ApplicationContainer container = new ApplicationContainer();
    private final RandomNumberGenerator randomNumberGenerator = container.getRandomNumberGenerator();

    @Test
    @DisplayName("pickUniqueRandomNumber()")
    void test() {
        // given
        List<Integer> numberList = randomNumberGenerator.pickUniqueRandomNumber(3, 1, 9);

        // when
        boolean result = isValid(numberList, 3);

        // then
        assertTrue(result);
    }

    private boolean isValid(List<Integer> numberList, int numberDigits) {
        Set<Integer> usedNumbers = new HashSet<>(numberList);

        return usedNumbers.size() == numberDigits;
    }
}
