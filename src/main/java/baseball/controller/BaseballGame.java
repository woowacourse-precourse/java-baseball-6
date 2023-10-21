package baseball.controller;

import static baseball.view.InputView.userInput;
import static baseball.view.OutputView.gameStartMessage;
import static baseball.view.OutputView.userInputMessage;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import java.util.List;


public class BaseballGame {
    private UserNumber userNumber;
    private List<Integer> computerNumber;

    /*public BaseballGame() {
        this.computerNumber = new ComputerNumber();
    }*/

    public void gameStart() {
        this.computerNumber = ComputerNumber.makeComputerNumber();
        gameStartMessage();
        userInputMessage();
        this.userNumber = new UserNumber(userInput());
    }

    //public static
}
