package baseball.moduleTest;

import baseball.UserNumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserNumberTest {

    @Test
    void 입력값_길이_확인() {
        UserNumber userNumber = new UserNumber();
        Assertions.assertThrows(IllegalArgumentException.class, () -> userNumber.testCheckLength("1234"));
    }

    @Test
    void 입력값_문자_확인() {
        UserNumber userNumber = new UserNumber();
        Assertions.assertThrows(IllegalArgumentException.class, () -> userNumber.testCheckDigit("ㄱ34"));
    }

    @Test
    void 입력값_변환_확인() {
        UserNumber userNumber = new UserNumber();
        List<Integer> integers = userNumber.testCheckStringToDigit("123");
        Assertions.assertEquals(integers.get(0), 1);
        Assertions.assertEquals(integers.get(1), 2);
        Assertions.assertEquals(integers.get(2), 3);
    }

    @Test
    void 중복값_확인() {
        UserNumber userNumber = new UserNumber();
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(1);
        inputList.add(2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> userNumber.testCheckDuplication(inputList));
    }

    @Test
    void 입력값_0포함_확인() {
        UserNumber userNumber = new UserNumber();
        List<Integer> inputList = new ArrayList<>();
        inputList.add(0);
        inputList.add(1);
        inputList.add(2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> userNumber.testCheckZero(inputList));
    }

}
