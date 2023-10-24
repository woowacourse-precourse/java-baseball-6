package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import baseball.player.Computer;
import baseball.util.generator.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    private RandomGenerator mockRandomGenerator;
    private Computer computer;

    @BeforeEach
    public void setUp() {
        mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.pickNumberInRange(1, 9)).thenReturn(1, 2, 3);
        computer = new Computer(mockRandomGenerator);
    }

    @Test
    @DisplayName("랜덤 숫자 초기화 테스트")
    public void testInitialize() {
        assertEquals(1, computer.getNumberAt(0));
        assertEquals(2, computer.getNumberAt(1));
        assertEquals(3, computer.getNumberAt(2));
    }

    @Test
    @DisplayName("특정 숫자가 리스트에 포함되어 있는지 테스트")
    public void testContainsNumber() {
        assertTrue(computer.containsNumber(1));
        assertTrue(computer.containsNumber(2));
        assertTrue(computer.containsNumber(3));
        assertFalse(computer.containsNumber(4));
    }

    @Test
    @DisplayName("리스트 초기화 후 랜덤 숫자 재설정 테스트")
    public void testClearAndInitialize() {
        when(mockRandomGenerator.pickNumberInRange(1, 9)).thenReturn(4, 5, 6);
        computer.clearAndInitialize();
        assertEquals(4, computer.getNumberAt(0));
        assertEquals(5, computer.getNumberAt(1));
        assertEquals(6, computer.getNumberAt(2));
    }

    @Test
    @DisplayName("랜덤 숫자 중복 시 재생성 테스트")
    public void testDuplicateRandomNumbers() {
        // 랜덤 값 중복을 시뮬레이션
        when(mockRandomGenerator.pickNumberInRange(1, 9)).thenReturn(1, 2, 2, 3);

        // Computer 객체 재생성
        computer = new Computer(mockRandomGenerator);

        // 결과 검증
        assertEquals(1, computer.getNumberAt(0));
        assertEquals(2, computer.getNumberAt(1));
        assertEquals(3, computer.getNumberAt(2));
    }

}
