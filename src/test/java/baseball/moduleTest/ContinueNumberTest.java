package baseball.moduleTest;

import baseball.ContinueNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContinueNumberTest {

    @Test
    void 재시작_입력값_판별() {
        ContinueNumber continueNumber = new ContinueNumber();
        Assertions.assertThrows(IllegalArgumentException.class, () -> continueNumber.testCheckContinueNumber("3"));
    }
}
