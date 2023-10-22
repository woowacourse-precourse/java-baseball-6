package baseball.model;

import baseball.utils.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class computerTest {

    private computer testComputer;

    @DisplayName("예상 가능한 모의 객체 생성")
    @BeforeEach
    public void setUp() {
        // Initialize with a mock random number generator that always generates the same sequence.
        testComputer = new computer(new RandomNumberGenerator() {
            int count = 0;
            @Override
            public int generateNumberInRange(int min, int max) {
                return ++count; // Returns 1, then 2, then 3...
            }
        });
    }

    @DisplayName("생성된 모의 객체를 기반으로 테스트")
    @Test
    public void generate_numbersAreUnique() {
        testComputer.generate();

        assertEquals(3, testComputer.getComNumber().size());

        assertTrue(testComputer.getComNumber().contains(1));
        assertTrue(testComputer.getComNumber().contains(2));
        assertTrue(testComputer.getComNumber().contains(3));
    }
  
}