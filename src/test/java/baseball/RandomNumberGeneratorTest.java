package baseball;


import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.RandomNumberGenerator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private boolean hasDuplicationInList(List<Integer> inputList) {
        Set<Integer> set;
        set = new HashSet<>(inputList);
        return set.size() < inputList.size();
    }

    @Test
    void testGenerateRandomNumber() {
        List<Integer> generatedNumbers = randomNumberGenerator.generateRandomNumber();

        boolean isSizeThree = generatedNumbers.size() == 3;
        boolean hasDuplication = hasDuplicationInList(generatedNumbers);

        assertThat(isSizeThree).isTrue();
        assertThat(!hasDuplication).isTrue();
    }
}
