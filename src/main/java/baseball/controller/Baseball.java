package baseball.controller;

import baseball.domain.ComputerNumber;
import baseball.domain.UserNumber;
import baseball.service.CheckNumberService;
import baseball.view.ConsoleView;


public class Baseball {
    private final ComputerNumber computerNumber;
    private UserNumber userNumber;

    private CheckNumberService checkNumberService;
    public Baseball() {
        computerNumber = new ComputerNumber();
        checkNumberService = new CheckNumberService();
    }

    public void gameStart() {
        while (true) {
            userNumber = new UserNumber(ConsoleView.userNumber());
            if (checkNumber()) {
                break;
            }
        }
    }

    public boolean checkNumber() {
        int [] result = checkNumberService.checkNumber(userNumber.getUserNumber(), computerNumber.getComputerNumber());
        if (result[0]==0 && result[1] == 0) {
            ConsoleView.nothing();
            return false;
        }
        if (result[1] == 3) {
            ConsoleView.gameEnd();
            return true;
        }
        ConsoleView.ballStrike(result[0], result[1]);
        return false;
    }

}
