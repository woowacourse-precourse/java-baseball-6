package baseball.contriller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;

public class BaseballGame {
    private UserNumber userNumber;
    private ComputerNumber computerNumber;

    public BaseballGame(UserNumber userNumber, ComputerNumber computerNumber) {
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;
    }


}
