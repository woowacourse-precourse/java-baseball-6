package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import baseball.model.Computer;
import baseball.util.Constants;
import org.junit.jupiter.api.Test;

public class ComputerNumberTest {

    @Test
    void 컴퓨터_숫자_자리수_맞는지_테스트() {
        Computer computer = new Computer();
        assertEquals(Constants.BALL_LENGTH, computer.getNumbersLength());
    }

    @Test
    void 컴퓨터_숫자_중복값_있는지_테스트() {
        Computer computer = new Computer();
        assertFalse(computer.hasDuplicatedNumber(), "중복된 값이 있습니다");
    }

}
