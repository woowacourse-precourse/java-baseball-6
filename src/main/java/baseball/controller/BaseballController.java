package baseball.controller;

import baseball.model.Computer;
import baseball.view.OutputView;

public class BaseballController {

    Computer computer = new Computer();
    public void startGame(){
        OutputView.baseballGameStart();
        System.out.println(computer.getComputerNumber());
    }
}
