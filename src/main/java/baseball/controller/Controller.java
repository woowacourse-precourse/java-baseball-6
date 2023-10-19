package baseball.controller;

import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    Computer computer = new Computer();
    public void run(){
        computer.generateRandomNumber();
        OutputView.printStartGame();
        OutputView.printInputNumber();
        InputView.userInput();
    }



}
