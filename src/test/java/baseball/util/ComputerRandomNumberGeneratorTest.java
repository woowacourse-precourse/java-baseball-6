package baseball.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ComputerRandomNumberGeneratorTest {
    private RandomNumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new ComputerRandomNumberGenerator();
    }

    @Test
    void 랜덤수_생성() {
        int randomNumber = generator.generateRandomNumber(1, 9);
        assertTrue(randomNumber >= 1 && randomNumber <= 9);
    }

    @Test
    void 생성된_랜덤수들의_크기_확인() {
        List<Integer> uniqueNumbers = generator.createUniqueNumbers(3);
        Set<Integer> set = new HashSet<>(uniqueNumbers);
        assertThat(set.size()).isEqualTo(3);
    }

}

