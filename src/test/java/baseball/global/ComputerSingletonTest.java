package baseball.global;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerSingletonTest {

    @Test
    void 같은_객체를_반환하는지_체크() {
        ComputerSingleton computerSingleton = ComputerSingleton.getInstance();
        ComputerSingleton computerSingleton2 = ComputerSingleton.getInstance();
        assertEquals(computerSingleton, computerSingleton2);
    }

    @Test
    void 중복된_숫자를_생성하는지_체크() {

    }

}