package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.StringTokenizer;

public class BaseballGameController {

    Computer computer;
    public BaseballGameController(){
        OutputView.printGameInitMessage();
    }


    public void gameStart(){
        String userNumber;

        InputView.printInputNumberMessage();
        userNumber = InputView.getInputNumber();
        BaseballGame baseballGame = new BaseballGame();



    }




}
