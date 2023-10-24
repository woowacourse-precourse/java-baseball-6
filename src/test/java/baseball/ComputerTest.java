package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    void 컴퓨터_랜덤_숫자_유효성_테스트() {
        Computer computer = new Computer();
        String computerNumbers = computer.getComputerNumbers();

        assertDoesNotThrow(() -> {
            Player player = new Player(computerNumbers);
        });
    }
}
