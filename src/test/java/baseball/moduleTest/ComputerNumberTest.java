package baseball.moduleTest;

import baseball.validation.ComputerNumber;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerNumberTest {
    @Test
    void 컴퓨터_랜덤_숫자_확인() {
        ComputerNumber computerNumberService = new ComputerNumber();
        List<Integer> computerNumber = computerNumberService.createComputerNumber();
        System.out.println("computerNumber = " + computerNumber);
        Assertions.assertEquals(computerNumber.size(), 3);
    }
}
