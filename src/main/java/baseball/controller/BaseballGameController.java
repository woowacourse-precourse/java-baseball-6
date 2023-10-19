package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    public BaseballGameController(){
        OutputView.printGameInitMessage();
    }


    public void gameStart(){
        InputView.printInputNumberMessage();


    }




}
