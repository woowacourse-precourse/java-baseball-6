package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.Computer;
import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.StringTokenizer;

public class BaseballGameController {

    BaseballGameService baseballGameService;

    public BaseballGameController(){
        OutputView.printGameInitMessage();
    }


    public void gameStart(){
        String userNumber;

        InputView.printInputNumberMessage();
        userNumber = InputView.getInputNumber();
        baseballGameService = new BaseballGameService();
        String [] results = baseballGameService.run(userNumber);






    }




}
