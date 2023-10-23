package baseball;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModuleTest {

    @Test
    void 컴퓨터_랜덤_숫자_확인() {
        ComputerNumber computerNumberService = new ComputerNumber();
        List<Integer> computerNumber = computerNumberService.createComputerNumber();
        System.out.println("computerNumber = " + computerNumber);
        Assertions.assertEquals(computerNumber.size(), 3);
    }

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

}
