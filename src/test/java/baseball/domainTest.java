package baseball;

import baseball.domain.ComputerNumber;
import baseball.domain.UserNumber;
import org.junit.jupiter.api.Test;

public class domainTest {
    @Test
    void 랜덤_테스트() {
        ComputerNumber computerNumber = new ComputerNumber();
        System.out.println(computerNumber.getComputerNumber());
    }

    @Test
    void 유저_테스트() {
        UserNumber userNumber = new UserNumber("123");
        System.out.println(userNumber.getUserNumber());
    }
}
