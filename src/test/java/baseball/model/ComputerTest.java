package baseball.model;

import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void 숫자_생성_테스트() {
        for (int i = 0; i < 10; i++) {
            Computer computer = new Computer();
            System.out.println(computer.getNumbers());
        }
    }
}