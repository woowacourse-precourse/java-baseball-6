package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGame {

    public void run(){

        OutputView.printStartMessage();


    }

    private void startNewGame(){
        InputView.readPlayerNumber();

    }

}
