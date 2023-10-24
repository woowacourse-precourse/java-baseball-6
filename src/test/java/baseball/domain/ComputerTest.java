package baseball.domain;

import baseball.domain.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void testGenerateAnswer() {
        List<Integer> answer = computer.getAnswer();
        assertNotNull(answer);
        assertEquals(3, answer.size()); // 생성된 답안이 3자리 숫자인지 확인
    }

    @Test
    void testCreateNumber() {
        List<Integer> number = computer.createNumber();
        assertEquals(3, number.size()); // 생성된 숫자가 3자리인지 확인
        assertTrue(number.stream().allMatch(n -> n >= 1 && n <= 9)); // 숫자 범위 확인
        // 중복 숫자가 없는지 확인
        for (int i = 0; i < number.size(); i++) {
            for (int j = i + 1; j < number.size(); j++) {
                assertTrue(number.get(i) != number.get(j));
            }
        }
    }
}
