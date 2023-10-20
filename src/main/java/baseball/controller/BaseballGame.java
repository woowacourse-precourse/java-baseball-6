package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private ComputerNumber computerNumber;

    public BaseballGame(){
        computerNumber = new ComputerNumber();

    }

    public void start(){
        OutputView.printStart();
        playGame();


    }
    public void playGame(){
        UserNumber userNumber = new UserNumber(InputView.inputNumber());
        String input = userNumber.getUserNumber();
    }
}
