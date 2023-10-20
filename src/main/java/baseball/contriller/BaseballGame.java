package baseball.contriller;

import static baseball.view.InputView.userInput;
import static baseball.view.OutputView.gameStartMessage;
import static baseball.view.OutputView.userInputMessage;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;


public class BaseballGame {
    private UserNumber userNumber;
    private ComputerNumber computerNumber;

    /*public BaseballGame() {
        this.computerNumber = new ComputerNumber();
    }*/

    public void gameStart() {
        this.computerNumber = new ComputerNumber();
        gameStartMessage();
        userInputMessage();
        this.userNumber = new UserNumber(userInput());
    }

}
