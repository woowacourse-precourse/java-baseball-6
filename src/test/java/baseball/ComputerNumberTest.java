package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import baseball.model.ComputerNumber;
import baseball.util.Constants;
import org.junit.jupiter.api.Test;

public class ComputerNumberTest {

    @Test
    void 컴퓨터_숫자_자리수_맞는지_테스트() {
        ComputerNumber computerNumber = new ComputerNumber();
        assertEquals(Constants.BALL_LENGTH, computerNumber.getSize());
    }

    @Test
    void 컴퓨터_숫자_중복값_있는지_테스트() {
        ComputerNumber computerNumber = new ComputerNumber();
        assertFalse(computerNumber.hasDuplicatedNumber(), "중복된 값이 있습니다");
    }

}
