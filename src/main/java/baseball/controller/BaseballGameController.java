package baseball.controller;

import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    Computer computer;
    public BaseballGameController(){
        OutputView.printGameInitMessage();
    }


    public void gameStart(){
        InputView.printInputNumberMessage();
        InputView.getInputNumber();
        computer = new Computer();
        System.out.println(computer.randomComputerNumber());



    }




}
