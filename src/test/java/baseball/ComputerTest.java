package baseball;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    void 컴퓨터_랜덤_숫자_유효성_테스트() {
        Computer computer = new Computer();
        String randomNumbers = computer.getComputerNumbers();

        try {
            Player player = new Player(randomNumbers);
        } catch (IllegalArgumentException e) {
            fail("예외가 발생했습니다: " + e.getMessage());
        }
    }
}
