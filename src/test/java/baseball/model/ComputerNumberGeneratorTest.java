package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ComputerNumberGeneratorTest {
    static List<Integer> computerNumbers;

    @BeforeAll
    static void init() {
        ComputerNumberGenerator createComputerNumber = new ComputerNumberGenerator();
        computerNumbers = createComputerNumber.getComputerNumber();
    }

    @Test
    void 총_3개의_숫자_생성() {
        assertEquals(3, computerNumbers.size());
    }

    @Test
    void 생성된_숫자가_모두_다른_숫자() {
        Set<Integer> uniqueNumbers = new HashSet<>(computerNumbers);
        assertEquals(3, uniqueNumbers.size());
    }

    @Test
    void 숫자가_1과_9사이() {
        for (int num : computerNumbers) {
            assertTrue(num >= 1 && num <= 9);
        }
    }
}