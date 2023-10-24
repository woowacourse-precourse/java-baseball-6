package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    static Computer computer;

    @BeforeAll
    static void setup() {
        computer = new Computer();
        computer.makeNumberSet();
    }

    @Test
    void 결과_생성_낫싱() {

    }

    @Test
    void 결과_생성_볼() {

    }

    @Test
    void 결과_생성_스트라이크() {

    }

    @Test
    void 결과_생성_볼_스트라이크() {

    }
}
