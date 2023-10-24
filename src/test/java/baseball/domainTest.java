package baseball;

import baseball.domain.ComputerNumber;
import baseball.domain.UserNumber;
import baseball.view.ConsoleView;
import org.junit.jupiter.api.Test;

public class domainTest {
    @Test
    void 랜덤_테스트() {
        ComputerNumber computerNumber = new ComputerNumber();
        System.out.println(computerNumber.getComputerNumber());
    }

    @Test
    void 유저_테스트() {
        UserNumber userNumber = new UserNumber("-12");
        System.out.println(userNumber.getUserNumber());
    }

    @Test
    void 콘솔_테스트() {
        ConsoleView.ballStrike(1,2);
    }
}
